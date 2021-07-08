package com.example.mobileprogrammingproject.fragments

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobileprogrammingproject.MainMenuActivity
import com.example.mobileprogrammingproject.R
import com.example.mobileprogrammingproject.databinding.FragmentMenuBinding
import com.example.mobileprogrammingproject.dialogs.RuleDialog
import com.example.mobileprogrammingproject.dialogs.SettingsDialog


class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        //start play button
        binding.playButton.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_playFragment3)
        }
        //end play button
        //start rules button
        binding.rulesButton.setOnClickListener {
            val rulesFile = RuleDialog()
            rulesFile.show(parentFragmentManager, "rulesDialogTag")
        }
        //end rules button

        //start settings button
        binding.settingsButton.setOnClickListener {
            val GameSettingsDialog = SettingsDialog()
            GameSettingsDialog.show(parentFragmentManager,"SettingsDialogTag")
            val PlayerNumber = activity?.intent?.getStringExtra("PlayerNumber")?.toInt()
            }

        //end settings button

        //start exit button
        binding.exitButton.setOnClickListener {
            activity?.finish()
        }
        //end exit button

        return view
    }
}