package com.example.mobileprogrammingproject.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.mobileprogrammingproject.R
import java.lang.Exception
import java.lang.IllegalStateException

class SettingsDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            var MatchType : Int
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Choose the number of players that will play the game...")
            builder.setSingleChoiceItems(R.array.SelectMatch,0) { _: DialogInterface, _: Int -> }
                .setNegativeButton(R.string.Cancel) { dialogInterface: DialogInterface, i: Int ->
                    it.finish()
                }
                .setPositiveButton(R.string.Ok) { _: DialogInterface, _: Int ->
                }
            builder.create()
        }?:throw IllegalStateException("ripijate")

    }
}