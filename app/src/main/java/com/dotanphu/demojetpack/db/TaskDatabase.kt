package com.dotanphu.demojetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dotanphu.demojetpack.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDao

    companion object {
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(context: Context, coroutineScope: CoroutineScope): TaskDatabase {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, TaskDatabase::class.java, "taskPaging.db")
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                coroutineScope.launch(Dispatchers.IO) {
                                    for (i in 1..10000) {
                                        INSTANCE!!.getTaskDao().insertTask(
                                            Task(i, "$i", "$i", i)
                                        )
                                    }
                                }
                            }
                        })
                        .build()
            }
            return INSTANCE!!
        }
    }
}