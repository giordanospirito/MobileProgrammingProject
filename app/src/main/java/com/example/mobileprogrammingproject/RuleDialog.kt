package com.example.mobileprogrammingproject

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class RuleDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.Regolamento)
            builder.setMessage(R.string.Rules)
            builder.setNegativeButton(R.string.close) { _, _ -> }
            builder.create()
        }?:throw IllegalStateException("Error")
    }
}