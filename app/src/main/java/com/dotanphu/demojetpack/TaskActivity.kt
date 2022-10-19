package com.dotanphu.demojetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dotanphu.demojetpack.adapter.TaskAdapter
import com.dotanphu.demojetpack.databinding.ActivityTaskBinding
import com.dotanphu.demojetpack.vm.TaskViewModel
import kotlinx.coroutines.flow.collectLatest

class TaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskBinding
    private val viewModel by viewModels<TaskViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TaskAdapter()
        binding.rvTask.adapter = adapter
        binding.rvTask.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lifecycleScope.launchWhenStarted {
            viewModel.taskPaging.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}