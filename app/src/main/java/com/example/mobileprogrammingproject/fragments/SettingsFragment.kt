package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.mobileprogrammingproject.R
import com.example.mobileprogrammingproject.databinding.FragmentPlayBinding
import com.example.mobileprogrammingproject.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

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

        ApplyButton.setOnClickListener {
            var canContinue = 0
            if (SinglePlayerCheck.isChecked) {
                canContinue = 1
            }
            if (TwoPlayersCheck.isChecked) {
                canContinue = 1
            }
            if (ThreePlayersCheck.isChecked) {
                canContinue = 1
            }
            if (FourPlayersCheck.isChecked) {
                canContinue = 1
            }

            if (canContinue == 0) {
                Toast.makeText(this.context, "Select a game-mode first", Toast.LENGTH_SHORT).show()
            }

            if (SinglePlayerCheck.isChecked) {
                val action = SettingsFragmentDirections.actionSettingsFragmentToMenuFragment()
                findNavController().navigate(action)
            }
        }


        return view
    }
}