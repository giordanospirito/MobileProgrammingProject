package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobileprogrammingproject.MainMenuActivity
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

        val FirstPlaceName : String = ReturnPlace(1,args.myScoreArg2,scorePlayer2,scorePlayer3,scorePlayer4,args.username)
        val SecondPlaceName : String = ReturnPlace(2,args.myScoreArg2,scorePlayer2,scorePlayer3,scorePlayer4,args.username)
        val ThirdPlaceName : String = ReturnPlace(3,args.myScoreArg2,scorePlayer2,scorePlayer3,scorePlayer4,args.username)
        val FourthPlaceName : String = ReturnPlace(4,args.myScoreArg2,scorePlayer2,scorePlayer3,scorePlayer4,args.username)

        binding.firstPlaceUsarname.text = FirstPlaceName
        binding.secondPlaceUsarname.text = SecondPlaceName
        binding.thirdPlaceUsarname.text = ThirdPlaceName
        binding.fourthPlaceUsarname.text = FourthPlaceName

        binding.firstPlaceScore.text = getScoreRelatedTo(1,args.myScoreArg2,scorePlayer2,scorePlayer3,scorePlayer4).toString()
        binding.secondPlaceScore.text = getScoreRelatedTo(2,args.myScoreArg2,scorePlayer2,scorePlayer3,scorePlayer4).toString()
        binding.thirdPlaceScore.text = getScoreRelatedTo(3,args.myScoreArg2,scorePlayer2,scorePlayer3,scorePlayer4).toString()
        binding.fourthPlaceScore.text = getScoreRelatedTo(4,args.myScoreArg2,scorePlayer2,scorePlayer3,scorePlayer4).toString()

        binding.back.setOnClickListener {
            val action = EndGameFragmentDirections.actionEndGameFragmentToMenuFragment()
            findNavController().navigate(action)
        }

        return view
    }

    private fun getScoreRelatedTo(i: Int, myScoreArg2: Int, scorePlayer2: Int, scorePlayer3: Int, scorePlayer4: Int): Int {
        var Classific = listOf<Int>(myScoreArg2,scorePlayer2,scorePlayer3,scorePlayer4)
        var SortedClassific = Classific.sortedDescending()
        return SortedClassific[i-1]
    }

    private fun ReturnPlace(value: Int,myScore:Int,ScoreP2:Int,ScoreP3:Int,ScoreP4:Int,username:String): String {
        var Classific = listOf<Int>(myScore,ScoreP2,ScoreP3,ScoreP4)
        var SortedClassific = Classific.sortedDescending()
        var ClassifiedMember = when(SortedClassific[value-1]){
            myScore->username
            ScoreP2->getString(R.string.Player_2)
            ScoreP3->getString(R.string.Player_3)
            else->getString(R.string.player_4)
        }
        return ClassifiedMember
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