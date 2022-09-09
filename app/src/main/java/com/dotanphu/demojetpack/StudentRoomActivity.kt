package com.dotanphu.demojetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dotanphu.demojetpack.adapter.StudentAdapter
import com.dotanphu.demojetpack.databinding.ActivityStudentRoomBinding
import com.dotanphu.demojetpack.model.Student
import com.dotanphu.demojetpack.vm.StudentViewModel
import com.dotanphu.demojetpack.vm.StudentViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentRoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentRoomBinding
    private val viewModel: StudentViewModel by viewModels() {
        StudentViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRV()

        binding.btnAdd.setOnClickListener {
            val name = binding.edtName.text.toString()
            val address = binding.edtAddress.text.toString()
            viewModel.insertStudent(Student(name = name, address = address))
        }
        binding.btnUpdate.setOnClickListener {
            val id = binding.edtId.text.toString().toInt()
            val name = binding.edtName.text.toString()
            val address = binding.edtAddress.text.toString()
            viewModel.updateStudent(Student(id, name = name, address = address))
        }
        binding.btnDelete.setOnClickListener {
            val id = binding.edtId.text.toString().toInt()
            viewModel.deleteStudent(id)
        }
        binding.btnFind.setOnClickListener {
            val id = binding.edtId.text.toString().toInt()
            lifecycleScope.launch(Dispatchers.IO){
                viewModel.findStudent(id)
            }
        }

    }

    private fun setupRV() {
        val studentAdapter = StudentAdapter()
        viewModel.student.observe(this) {
            studentAdapter.submitList(it)
        }

        binding.rvStudent.adapter = studentAdapter
        binding.rvStudent.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}