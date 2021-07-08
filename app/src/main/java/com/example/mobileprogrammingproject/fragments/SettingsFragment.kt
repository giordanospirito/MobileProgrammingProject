package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.mobileprogrammingproject.R
import com.example.mobileprogrammingproject.databinding.FragmentPlayBinding
import com.example.mobileprogrammingproject.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        //logic...
        val ApplyButton = binding.BackButton
        val SinglePlayerCheck = binding.SinglePlayerButton
        val TwoPlayersCheck = binding.TwoPlayerButton
        val ThreePlayersCheck = binding.ThreePlayerButton
        val FourPlayersCheck = binding.FourPlayerButton

        ApplyButton.setOnClickListener {
            if(SinglePlayerCheck.isChecked){
                val action = SettingsFragmentDirections.actionSettingsFragmentToPlayFragment3(1)
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_menuFragment2)
            }
            if(TwoPlayersCheck.isChecked){
                val action = SettingsFragmentDirections.actionSettingsFragmentToPlayFragment3(2)
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_menuFragment2)
            }
            if(ThreePlayersCheck.isChecked){
                val action = SettingsFragmentDirections.actionSettingsFragmentToPlayFragment3(3)
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_menuFragment2)
            }
            if(FourPlayersCheck.isChecked){
                val action = SettingsFragmentDirections.actionSettingsFragmentToPlayFragment3(4)
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_menuFragment2)
            }
            else{
                Toast.makeText(this.context, "Select a game-mode first",Toast.LENGTH_SHORT).show()
            }
        }



        return view
    }
}