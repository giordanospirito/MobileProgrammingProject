package com.example.mobileprogrammingproject.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.mobileprogrammingproject.R

class CreditsDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it, R.style.Theme_MyDialogs)
            builder.setTitle(R.string.credit)
            builder.setMessage(R.string.credits)
                .setPositiveButton(R.string.ok) { _: DialogInterface, _: Int -> }
            builder.create()
        } ?: throw IllegalStateException("Error")
    }
}


