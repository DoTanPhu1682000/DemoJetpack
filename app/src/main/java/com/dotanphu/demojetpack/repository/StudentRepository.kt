package com.dotanphu.demojetpack.repository

import androidx.lifecycle.LiveData
import com.dotanphu.demojetpack.db.StudentDao
import com.dotanphu.demojetpack.model.Student

class StudentRepository(private val studentDao: StudentDao) {

    suspend fun insertStudent(student: Student) {
        studentDao.insertStudent(student)
    }

    suspend fun updateStudent(student: Student) {
        studentDao.updateStudent(student)
    }

    suspend fun deleteStudent(student: Student) {
        studentDao.deleteStudent(student)
    }

    suspend fun deleteStudentById(id: Int) {
        studentDao.deleteStudentById(id)
    }

    suspend fun getStudentById(id: Int): Student {
        return studentDao.getStudentById(id)
    }

    suspend fun getAllStudent(): List<Student> {
        return studentDao.getAllStudent()
    }

    fun getAllStudentWithLiveData(): LiveData<List<Student>> {
        return studentDao.getAllStudentWithLiveData()
    }
}