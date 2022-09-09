package com.dotanphu.demojetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dotanphu.demojetpack.adapter.StudentAdapter
import com.dotanphu.demojetpack.databinding.ActivityMainBinding
import com.dotanphu.demojetpack.model.Student

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentList = arrayListOf(
            Student(1, "Phu", "HaNoi"),
            Student(2, "Tu", "ThaiBinh"),
            Student(3, "Long", "GiaLai"),
            Student(4, "Quan", "HaTay"),
            Student(5, "Giang", "BacGiang"),
        )

        val adapter = StudentAdapter()
        adapter.submitList(studentList)
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}