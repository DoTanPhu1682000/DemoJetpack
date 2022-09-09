package com.dotanphu.demojetpack.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dotanphu.demojetpack.db.StudentDatabase
import com.dotanphu.demojetpack.model.Student
import com.dotanphu.demojetpack.repository.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentViewModel(private val app: Application) : ViewModel() {
    private val studentRepository = StudentRepository(
        StudentDatabase.getInstance(app.applicationContext, viewModelScope).getStudentDao()
    )

    val student = studentRepository.getAllStudentWithLiveData()

    fun insertStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.insertStudent(student)
        }
    }

    fun updateStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.updateStudent(student)
        }
    }

    fun deleteStudent(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.deleteStudentById(id)
        }
    }

    suspend fun findStudent(id: Int): Student {
        val student = viewModelScope.async(Dispatchers.IO) {
            studentRepository.getStudentById(id)
        }
        return student.await()
    }

}