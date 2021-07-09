package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobileprogrammingproject.MainMenuActivity
import com.example.mobileprogrammingproject.R
import com.example.mobileprogrammingproject.data.User
import com.example.mobileprogrammingproject.data.UserViewModel
import com.example.mobileprogrammingproject.databinding.FragmentMenuBinding
import com.example.mobileprogrammingproject.dialogs.RuleDialog


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private lateinit var myViewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //binding
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        //end binding

        //initializing DB
        myViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        //start play button
        binding.playButton.setOnClickListener {
            if(binding.UsernameEditText.text.toString() != ""){
                val action = MenuFragmentDirections.actionMenuFragmentToPlayFragment(0)
                val newUser = User(0,binding.UsernameEditText.text.toString(),0,numbersRepetition = false,bonus = false,scale4 = false,scale5 = false,tris = false,quater = false,full = false,yahtzee = false,false)
                myViewModel.addUser(newUser)
                findNavController().navigate(action)
            }
            else{
                Toast.makeText(this.context, "Insert your username before playing", Toast.LENGTH_SHORT).show()
            }

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
        if ((activity as MainMenuActivity).wantMusic){
            binding.volumeButton.setImageResource(R.drawable.ic_baseline_volume_up_24)
        } else {
            binding.volumeButton.setImageResource(R.drawable.ic_baseline_volume_off_24)
        }
        binding.volumeButton.setOnClickListener{
            if ( (activity as MainMenuActivity).wantMusic ) {
                (activity as MainMenuActivity).wantMusic = false
                binding.volumeButton.setImageResource(R.drawable.ic_baseline_volume_off_24)
                (activity as MainMenuActivity).mediaPlayer.pause()
            } else{
                (activity as MainMenuActivity).wantMusic = true
                binding.volumeButton.setImageResource(R.drawable.ic_baseline_volume_up_24)
                (activity as MainMenuActivity).mediaPlayer.start()
            }
        }
        //end volume button

        return view
    }

}