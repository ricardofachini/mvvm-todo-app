package com.example.todoapp.home


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.Task
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.home.adapter.TasksAdapter
import com.example.todoapp.home.newtask.NewTaskDialogFragment
import com.example.todoapp.home.newtask.NewTaskDialogListener
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

    /**
     * When the user presses add button to add new task in dialog
     */
    override fun onPositiveClick(title: String) {
        val task = Task(
            id = 0,
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