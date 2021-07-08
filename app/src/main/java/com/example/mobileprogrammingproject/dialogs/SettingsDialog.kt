package com.example.mobileprogrammingproject.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.core.graphics.component1
import androidx.fragment.app.DialogFragment
import com.example.mobileprogrammingproject.R
import java.lang.Exception
import java.lang.IllegalStateException
import kotlin.properties.Delegates

class SettingsDialog : DialogFragment() {
    private var MatchType by Delegates.notNull<Int>()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            var position = 0
            val list: Array<out String> = it.resources.getStringArray(R.array.SelectMatch)
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Choose the number of players that will play the game...")
            builder.setItems(list) { _: DialogInterface, i: Int ->
                //todo va sistemato
                if(list[i] == "Singleplayer(training)"){
                    Toast.makeText(it, "bravo", Toast.LENGTH_SHORT).show()
                }
            }
            builder.create()
        }?:throw IllegalStateException("ripijate")

    }
}