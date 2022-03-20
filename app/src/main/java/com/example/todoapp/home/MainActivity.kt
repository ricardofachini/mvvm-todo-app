package com.example.todoapp.home


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.Todo
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.home.adapter.TasksAdapter
import com.example.todoapp.home.newtask.NewTaskDialogFragment
import com.example.todoapp.home.newtask.NewTaskDialogListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), NewTaskDialogListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TodoListViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        binding.addButton.setOnClickListener {
            NewTaskDialogFragment().show(supportFragmentManager, "TAG")
        }
    }

    override fun onPositiveClick(title: String) {
        val task = Todo(
            title = title,
            isDone = false
        )
        val tasksAdapter = TasksAdapter()
        binding.todoList.adapter =tasksAdapter
        binding.todoList.layoutManager = LinearLayoutManager(this)
        viewModel.addTask(task)
        tasksAdapter.submitList(viewModel.getList())
    }
}