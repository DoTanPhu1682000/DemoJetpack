package com.dotanphu.demojetpack.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.dotanphu.demojetpack.network.MoviesApi
import com.dotanphu.demojetpack.network.MoviesDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel
@Inject constructor(private val moviesApi: MoviesApi) : ViewModel() {

    val movies = Pager(PagingConfig(pageSize = 20)) {
        MoviesDataSource(moviesApi)
    }.flow.cachedIn(viewModelScope)

}