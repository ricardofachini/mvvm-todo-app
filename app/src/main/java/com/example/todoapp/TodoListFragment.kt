package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todoapp.databinding.FragmentTodoListBinding

class TodoListFragment: Fragment() {
    private lateinit var binding: FragmentTodoListBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentTodoListBinding.inflate(inflater, container, false).also {
            binding = it
            it.setupView()
        }.root
    }

    private fun FragmentTodoListBinding.setupView() {
    }
}