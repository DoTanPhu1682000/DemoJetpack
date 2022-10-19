package com.dotanphu.demojetpack.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.dotanphu.demojetpack.db.TaskDatabase

class TaskViewModel(private val app: Application) : AndroidViewModel(app) {

    private val taskDao = TaskDatabase.getInstance(app,viewModelScope).getTaskDao()

    val task = taskDao.getAllTaskWithLiveData()

    val taskPaging = Pager(PagingConfig(pageSize = 20)){
        taskDao.getTaskByPaing()
    }.flow.cachedIn(viewModelScope)
}