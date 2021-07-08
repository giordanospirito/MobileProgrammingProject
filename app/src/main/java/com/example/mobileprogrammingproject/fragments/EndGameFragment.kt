package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobileprogrammingproject.databinding.FragmentEndGameBinding
import com.example.mobileprogrammingproject.databinding.FragmentMenuBinding


class EndGameFragment : Fragment() {

    private var _binding: FragmentEndGameBinding? = null
    private val binding get() = _binding!!
    //val args:PlayFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //binding
        _binding = FragmentEndGameBinding.inflate(inflater, container, false)
        val view = binding.root
        //end binding

        return view
    }
}