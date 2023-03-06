package com.example.todoapp.home


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.Task
import com.example.todoapp.R
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.home.adapter.TasksAdapter
import com.example.todoapp.home.newtask.NewTaskDialogFragment
import com.example.todoapp.home.newtask.NewTaskDialogListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NewTaskDialogListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: TasksAdapter
    private val viewModel: TodoListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        myAdapter = TasksAdapter()
        binding.todoList.adapter = myAdapter
        binding.todoList.layoutManager = LinearLayoutManager(this)
        viewModel.getAllTasks()
        viewModel.tasksList.observe(this, Observer { data ->
            myAdapter.submitList(data)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_task -> {
                onTrashcanClicked()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }

    private fun onTrashcanClicked() {
        val toBeDeleteList: MutableList<Task> = mutableListOf()
        val list = myAdapter.currentList
        list.map {
            if (it.isDone) {
                toBeDeleteList.add(it)
            }
        }
        toBeDeleteList.map {
            viewModel.delete(it.id)
        }
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
        viewModel.addTask(task)
    }
}