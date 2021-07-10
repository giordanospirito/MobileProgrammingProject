package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobileprogrammingproject.MainMenuActivity
import com.example.mobileprogrammingproject.R
import com.example.mobileprogrammingproject.databinding.FragmentMenuBinding
import com.example.mobileprogrammingproject.dialogs.CreditsDialog
import com.example.mobileprogrammingproject.dialogs.RuleDialog


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    var fragmentWantMusic: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //binding
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        //end binding

        //init
        fragmentWantMusic = (activity as MainMenuActivity).wantMusic

        if (savedInstanceState != null) {
            fragmentWantMusic = savedInstanceState.getBoolean("savedfragmentwantMusic")
        }
        //end init

            //initializing DB

            //start play button
            binding.playButton.setOnClickListener {
                val action = MenuFragmentDirections.actionMenuFragmentToPlayFragment(0)
                if (binding.UsernameEditText.text.toString() != "") {
                    (activity as MainMenuActivity).editUserName(binding.UsernameEditText.text.toString())
                    //(activity as MainMenuActivity).userName = binding.UsernameEditText.text.toString()
                }
                findNavController().navigate(action)

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
                val action = MenuFragmentDirections.actionMenuFragmentToSettingsFragment()
                findNavController().navigate(action)
            }

            //end settings button

            //start exit button
            binding.exitButton.setOnClickListener {
                activity?.finish()
            }
            //end exit button

            //volume button
            if (fragmentWantMusic) {
                binding.volumeButton.setImageResource(R.drawable.ic_baseline_volume_up_24)
            } else {
                binding.volumeButton.setImageResource(R.drawable.ic_baseline_volume_off_24)
            }
            binding.volumeButton.setOnClickListener {
                if (fragmentWantMusic) {
                    (activity as MainMenuActivity).wantMusic = false
                    fragmentWantMusic = false
                    binding.volumeButton.setImageResource(R.drawable.ic_baseline_volume_off_24)
                    (activity as MainMenuActivity).mediaPlayer.pause()
                } else {
                    (activity as MainMenuActivity).wantMusic = true
                    fragmentWantMusic = true
                    binding.volumeButton.setImageResource(R.drawable.ic_baseline_volume_up_24)
                    (activity as MainMenuActivity).mediaPlayer.start()
                }
            }
            //end volume button

            //start credits button
            binding.CreditsButton.setOnClickListener {
                val CreditDialog = CreditsDialog()
                CreditDialog.show(parentFragmentManager, "CreditsDialog")
            }


        return view
    }


        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)

            outState.putBoolean("savedfragmentwantMusic", fragmentWantMusic)
        }

    }
