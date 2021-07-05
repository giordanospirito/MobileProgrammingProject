package com.example.mobileprogrammingproject.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.mobileprogrammingproject.R

class ExitGameDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.leaving)
                .setPositiveButton(R.string.yes) { _: DialogInterface, _: Int ->
                    it.finish()
                }
            builder.setNegativeButton(R.string.no) { _: DialogInterface, _: Int -> }
            builder.create()
        } ?: throw IllegalStateException("Error")
    }
}
