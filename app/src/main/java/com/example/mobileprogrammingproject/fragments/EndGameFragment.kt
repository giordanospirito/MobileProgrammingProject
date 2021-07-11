package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobileprogrammingproject.MainMenuActivity
import com.example.mobileprogrammingproject.R
import com.example.mobileprogrammingproject.databinding.FragmentEndGameBinding
import com.example.mobileprogrammingproject.databinding.FragmentMenuBinding
import com.example.mobileprogrammingproject.dialogs.ExitGameDialog
import java.util.*
import java.util.jar.Manifest


class EndGameFragment : Fragment() {

    private var _binding: FragmentEndGameBinding? = null
    private val binding get() = _binding!!
    private val args: EndGameFragmentArgs by navArgs()
    var fake = "fake"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //binding
        _binding = FragmentEndGameBinding.inflate(inflater, container, false)
        val view = binding.root
        //end binding

        val animation1 = AnimationUtils.loadAnimation(this.context, R.anim.slide_in_bottom)

        //initializing
        var scorePlayer2 = (activity as MainMenuActivity).ScoreP2
        var scorePlayer3 = (activity as MainMenuActivity).ScoreP3
        var scorePlayer4 = (activity as MainMenuActivity).ScoreP4

        //determining scores
        if((activity as MainMenuActivity).ScoreP2==0){
            scorePlayer2 = getRandomScore()
            (activity as MainMenuActivity).editScoreP2(scorePlayer2)
        }
        if((activity as MainMenuActivity).ScoreP3==0){
            scorePlayer3 = getRandomScore()
            (activity as MainMenuActivity).editScoreP3(scorePlayer3)
        }
        if((activity as MainMenuActivity).ScoreP4==0){
            scorePlayer4 = getRandomScore()
            (activity as MainMenuActivity).editScoreP4(scorePlayer4)
        }



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

        if (savedInstanceState==null){
            binding.firstPlace.startAnimation(animation1)
            binding.secondPlace.startAnimation(animation1)
            binding.thirdPlace.startAnimation(animation1)
            binding.fourthPlace.startAnimation(animation1)}

        binding.back.setOnClickListener {
            val dialog = ExitGameDialog()
            dialog.show(parentFragmentManager, "endgamedialog")
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("fake", fake)
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