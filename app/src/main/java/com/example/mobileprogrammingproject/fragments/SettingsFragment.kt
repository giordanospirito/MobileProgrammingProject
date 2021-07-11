package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobileprogrammingproject.MainMenuActivity
import com.example.mobileprogrammingproject.R
import com.example.mobileprogrammingproject.databinding.FragmentPlayBinding
import com.example.mobileprogrammingproject.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val settingsMode: Int = (activity as MainMenuActivity).gameMode

        //binding
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root
        //end binding

        //logic...
        val ApplyButton = binding.BackButton
        val SinglePlayerCheck = binding.SinglePlayerButton
        val TwoPlayersCheck = binding.TwoPlayerButton
        val ThreePlayersCheck = binding.ThreePlayerButton
        val FourPlayersCheck = binding.FourPlayerButton


        when(settingsMode){
            0 -> SinglePlayerCheck.isChecked = true
            1 -> TwoPlayersCheck.isChecked = true
            2 -> ThreePlayersCheck.isChecked = true
            3 -> FourPlayersCheck.isChecked = true
        }

        ApplyButton.setOnClickListener {
            var canContinue = 0
            if (SinglePlayerCheck.isChecked) {
                (activity as MainMenuActivity).editGameMode(0)
                canContinue = 1
            }
            if (TwoPlayersCheck.isChecked) {
                (activity as MainMenuActivity).editGameMode(1)
                canContinue = 1
            }
            if (ThreePlayersCheck.isChecked) {
                (activity as MainMenuActivity).editGameMode(2)
                canContinue = 1
            }
            if (FourPlayersCheck.isChecked) {
                (activity as MainMenuActivity).editGameMode(3)
                canContinue = 1
            }

            if (canContinue == 0) {
                Toast.makeText(this.context, getString(R.string.Select_gamemode), Toast.LENGTH_SHORT).show()
            }
        }


        return view
    }
}