package com.example.mobileprogrammingproject.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.graphics.component1
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mobileprogrammingproject.MainMenuActivity
import com.example.mobileprogrammingproject.R
import com.example.mobileprogrammingproject.fragments.MenuFragment
import com.example.mobileprogrammingproject.fragments.PlayFragment
import java.lang.Exception
import java.lang.IllegalStateException
import kotlin.properties.Delegates

class SettingsDialog : DialogFragment(){
    private var PlayerNumber : Int = 0
    private var MatchType by Delegates.notNull<Int>()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            var position = 0
            val list: Array<out String> = it.resources.getStringArray(R.array.SelectMatch)
            val builder = AlertDialog.Builder(it)
            var selectedId = 0
            builder.setTitle("Choose the number of players that will play the game...")
            builder.setSingleChoiceItems(list,0) { _: DialogInterface, which: Int ->
                selectedId = which+1
            }
                .setPositiveButton(R.string.select) { _: DialogInterface, _: Int ->
                    Intent(this.context,MenuFragment::class.java).apply{
                        putExtra("PlayerNumber",selectedId)
                    }
                    Toast.makeText(this.context,selectedId.toString(),Toast.LENGTH_LONG).show()
                }
            builder.create()
        }?:throw IllegalStateException("ripijate")
    }
}
