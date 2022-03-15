package com.example.todoapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.lang.ClassCastException
import java.lang.IllegalStateException

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

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.fragment_new_task_dialog, null))
                .setPositiveButton("Adicionar") { _, _ ->
                        listener.onPositiveClick()
                    }
                .setNegativeButton("Cancelar") { _,_ ->}

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}