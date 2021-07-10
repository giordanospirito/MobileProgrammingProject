package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobileprogrammingproject.R
import com.example.mobileprogrammingproject.databinding.FragmentEndGameBinding
import com.example.mobileprogrammingproject.databinding.FragmentMenuBinding
import java.util.*


class EndGameFragment : Fragment() {

    private var _binding: FragmentEndGameBinding? = null
    private val binding get() = _binding!!
    private val args: EndGameFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //binding
        _binding = FragmentEndGameBinding.inflate(inflater, container, false)
        val view = binding.root
        //end binding

        val scorePlayer2 = getRandomScore()
        val scorePlayer3 = getRandomScore()
        val scorePlayer4 = getRandomScore()


        val FirstPlaceName : String = ""
        val SecondPlaceName : String = ""
        val ThirdPlaceName : String = ""
        val FourthPlaceName : String = ""

        var list = listOf<String>(FirstPlaceName,SecondPlaceName,ThirdPlaceName,FourthPlaceName)




        binding.firstPlaceUsarname.text = FirstPlaceName

        binding.back.setOnClickListener {
            val action = EndGameFragmentDirections.actionEndGameFragmentToMenuFragment()
            findNavController().navigate(action)
        }

        return view
    }

    fun getRandomScore():Int{

        var score : Int= 0
        val ezPoints = listOf<Int>(0,5,10)
        val hardPoints = listOf<Int>(0,20,50,30,40,25)
        for (i in 0..10){
            score += ezPoints.random()
        }
        for (i in 0..3){
            score += hardPoints.random()
        }
        return score
    }
}