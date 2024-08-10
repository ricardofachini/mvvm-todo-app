package com.example.todoapp.home.newtask

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.todoapp.R
//import kotlinx.android.synthetic.main.fragment_new_task_dialog.*


class NewTaskDialogFragment: DialogFragment() {

    private lateinit var listener: NewTaskDialogListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as NewTaskDialogListener
        } catch (error: ClassCastException) {
            throw ClassCastException("Activity must implement ${listener::class.simpleName}")
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater
            val newTaskView = inflater.inflate(R.layout.fragment_new_task_dialog, null)
            val title = newTaskView.findViewById<EditText>(R.id.newTaskTitle)

            builder.setView(newTaskView)
                .setPositiveButton("Adicionar") { _, _ ->
                        val titleString = title.text.toString()
                        listener.onPositiveClick(titleString)
                    }
                .setNegativeButton("Cancelar") { dialog, which ->
                    getDialog()?.cancel()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}