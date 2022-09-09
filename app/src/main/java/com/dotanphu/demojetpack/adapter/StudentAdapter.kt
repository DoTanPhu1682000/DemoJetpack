package com.dotanphu.demojetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dotanphu.demojetpack.databinding.ItemStudentBinding
import com.dotanphu.demojetpack.model.Student

class StudentAdapter() : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    private val studentList = arrayListOf<Student>()

    fun submitList(temp: List<Student>) {
        studentList.clear()
        studentList.addAll(temp)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }

    override fun getItemCount() = studentList.size

    class StudentViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.tvName.text = student.name
            binding.tvAddress.text = student.address
        }
    }
}