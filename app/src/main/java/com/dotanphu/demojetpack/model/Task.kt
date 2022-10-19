package com.dotanphu.demojetpack.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Int = 0,
    @ColumnInfo(name = "_name")
    val name: String,
    @ColumnInfo(name = "_description")
    val description: String,
    @ColumnInfo(name = "_deadline")
    val deadline: Int,
)