package com.example.mobileprogrammingproject.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.mobileprogrammingproject.MainMenuActivity
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

                    (activity as MainMenuActivity).editScoreP2(0)
                    (activity as MainMenuActivity).editScoreP3(0)
                    (activity as MainMenuActivity).editScoreP4(0)
                    //isPlayButtonActivated:Boolean=true
                    //isAcceptButtonActivated:Boolean=false
                    //isScoreButtonActivated:Boolean=true
                    //playButtonColor = R.color.giallino
                    //acceptButtonColor = R.color.giallino
                    //scoreButtonColor = R.color.grey
                    (activity as MainMenuActivity).editCombo("")
                    (activity as MainMenuActivity).editScore(0)
                    //ActualScore:Int= 0
                    //arrayDices = mutableListOf<ImageView>()
                    (activity as MainMenuActivity).editNoroll(true)
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
