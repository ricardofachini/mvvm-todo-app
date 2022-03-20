package com.example.todoapp.home


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.home.newtask.NewTaskDialogFragment
import com.example.todoapp.home.newtask.NewTaskDialogListener

class MainActivity : AppCompatActivity(), NewTaskDialogListener {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeFragment(TodoListFragment())
        setupView()
    }


    private fun changeFragment(destinyFragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.container.id, destinyFragment)
            .commitAllowingStateLoss()
    }

    private fun setupView() {
        binding.addButton.setOnClickListener {
            NewTaskDialogFragment().show(supportFragmentManager, "TAG")
        }
    }

    override fun onPositiveClick() {
        Log.d("positive click:", "true")
    }
}