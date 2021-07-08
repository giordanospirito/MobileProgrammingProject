package com.example.mobileprogrammingproject.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.mobileprogrammingproject.R

class RuleDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it, R.style.Theme_MyDialogs)
            builder.setTitle(R.string.Regolamento)
            builder.setMessage(R.string.RulesLong)
            builder.setNegativeButton(R.string.close) { _: DialogInterface, _: Int -> }
            builder.create()
        }?:throw IllegalStateException("Error")
    }
}