package com.example.mobileprogrammingproject.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.mobileprogrammingproject.R
import com.example.mobileprogrammingproject.fragments.PlayFragment

class ExitGameDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it, R.style.Theme_MyDialogs)
            builder.setTitle(R.string.warning)

            if (findNavController().currentDestination?.id == R.id.endGameFragment ){
                builder.setMessage(R.string.endgame)}
            else{builder.setMessage(R.string.leaving)
                }

                .setPositiveButton(R.string.yes) { _: DialogInterface, _: Int ->
                    when (findNavController().currentDestination?.id){
                        R.id.menuFragment -> it.finish()
                        R.id.playFragment-> findNavController().navigate(R.id.menuFragment)
                        R.id.resultsFragment-> findNavController().navigate(R.id.menuFragment)
                        R.id.endGameFragment-> findNavController().navigate(R.id.menuFragment)
                    }

                }
            builder.setNegativeButton(R.string.no) { _: DialogInterface, _: Int -> }
            builder.create()
        } ?: throw IllegalStateException("Error")
    }
}
