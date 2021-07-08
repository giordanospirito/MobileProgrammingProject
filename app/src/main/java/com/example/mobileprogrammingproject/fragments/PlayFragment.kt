package com.example.mobileprogrammingproject.fragments

import android.content.Context
import android.icu.text.RelativeDateTimeFormatter
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import com.example.mobileprogrammingproject.R
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobileprogrammingproject.data.User
import com.example.mobileprogrammingproject.data.UserViewModel
import com.example.mobileprogrammingproject.databinding.FragmentPlayBinding
import java.sql.RowIdLifetime
import java.util.*

class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null
    private val binding get() = _binding!!
    private val diceImages = mutableListOf<Int>()
    private lateinit var animation1: Animation
    private lateinit var animation2: Animation
    private lateinit var animation3: Animation
    private lateinit var myViewModel: UserViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val vibe = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val vibeEff = VibrationEffect.createOneShot(50, 100)
        //Data arriving from dialog

        //initializing linkage to database
        myViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        //end linkage to database

        //start binding section
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        val view = binding.root
        //end binding section

        //start see result button
        binding.seeResults.setOnClickListener {
            findNavController().navigate(R.id.action_playFragment3_to_resultsFragment)
        }
        //end see result button

        //start roll section
        val rollResults = mutableListOf<Int>()
        val arrayDices = mutableListOf(binding.FirstRoll, binding.SecondRoll, binding.ThirdRoll, binding.FourthRoll, binding.FifthRoll)

        diceImagesAdder(diceImages)

        animation1 = AnimationUtils.loadAnimation(this.context, R.anim.shake_animation)
        animation2 = AnimationUtils.loadAnimation(this.context, R.anim.fade_in_delay)
        animation3 = AnimationUtils.loadAnimation(this.context, R.anim.fade_in)

        binding.RollerAndChecker.setOnClickListener {
            vibe.vibrate(vibeEff)
            rollResults.removeAll(listOf(1, 2, 3, 4, 5, 6))
            binding.dicesRow.visibility = View.VISIBLE

            for (i in 0..4) {
                getRandomValue(arrayDices[i], rollResults)
            }
            binding.dicesRow.startAnimation(animation3)
            binding.Combo.startAnimation(animation2)
            binding.ComboReader.startAnimation(animation2)
            binding.Score.startAnimation(animation2)
            binding.Combo.text = rollResults.toString()
            binding.ComboReader.text = getCombo(rollResults)
            binding.Score.text = getScore(getCombo(rollResults)).toString()
        }
        //end roll section

        //return section
        return view
    }







    //functions
    private fun getRandomValue(dice: ImageView?,list: MutableList<Int>){
        val random = Random().nextInt(6)
        dice?.startAnimation(animation1)
        dice?.setImageResource(diceImages.elementAt(random))
        list.add(random+1)
    } //get and add random value to rollResult. set right diceview
    private fun diceImagesAdder(diceImagesList: MutableList<Int>){
        diceImagesList.add(R.drawable.ic_dice_one)
        diceImagesList.add(R.drawable.ic_dice_two)
        diceImagesList.add(R.drawable.ic_dice_three)
        diceImagesList.add(R.drawable.ic_dice_four)
        diceImagesList.add(R.drawable.ic_dice_five)
        diceImagesList.add(R.drawable.ic_dice_six)
    } //given dicelist, adds to this the dices images of 1 to 6 dices
    private fun getScore(s: String): Int {
        val value = when(s){
            "Coppia" -> 5
            "Tris"->10
            "Quater" -> 20
            "Yahtzee" ->50
            "Scala da 4" ->30
            "Scala da 5" -> 40
            "Full" ->25
            else -> 0
        }
        return value
    }

    // Combo algorithm fun section
    private fun getCombo(List: MutableList<Int>): String {
        if (FiveASCorder(List)) {
            return "Scala da 5"
        } else {
            if (FourASCorder(List)) {
                return "Scala da 4"
            } else {
                for (i in 1..6) {
                    for (j in 1..6) {
                        if (isYahtzee(List,i)) {
                            return "Yahtzee"
                        } else {
                            if (isQuater(List,i)) {
                                return "Quater"
                            } else {
                                if (isFull(List)) {
                                    return "Full"
                                } else {
                                    if (isTriple(List, i)) {
                                        return "Tris"
                                    } else {
                                        if (isDouble(List, i)) {
                                            return "Coppia"
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return "NO combo"
    }

    private fun isFull(list: MutableList<Int>): Boolean {
        for (i in 1..6){
            if(isTriple(list,i)){
                for(j in 1..6){
                    if((i != j) and isDouble(list,j)){
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun BonusUsed(list: MutableList<Int>): Boolean {
        return false
    }

    private fun FiveASCorder(list: MutableList<Int>): Boolean {
        for(i in 0..4){
            if(list[i]<=list[i+1]){
                return false
            }
        }
        return true
    }

    private fun FourASCorder(list: MutableList<Int>): Boolean {
        for(i in 0..3){
            if(list[i]<=list[i+1]) {
                for (j in 1..4) {
                    if (list[j] <= list[j + 1]) {
                        return false
                    }
                }
            }
        }
        return true
    }

    private fun isYahtzee(List: MutableList<Int>, number: Int): Boolean {
        var counter = 0
        for (i in 0..4) {
            for (j in i+1..4) {
                if (List[i] == List[j] && List[i] == number) {
                    counter += 1
                }
                if (counter > 6) {
                    return true
                }
            }
        }
        return false
    }

    private fun isQuater(List: MutableList<Int>, number: Int): Boolean {
        var counter = 0
        for (i in 0..4) {
            for (j in i+1..4) {
                if (List[i] == List[j] && List[i] == number) {
                    counter += 1
                }
                if (counter == 6) {
                    return true
                }
            }
        }
        return false
    }

    private fun isTriple(List: MutableList<Int>, number:Int): Boolean {
        var counter = 0
        for (i in 0..4) {
            for (j in i+1..4) {
                if (List[i] == List[j] && List[i] == number) {
                    counter += 1
                }
                if (counter == 3) {
                    return true
                }
            }
        }
        return false
    }

    private fun isDouble(List: MutableList<Int>,number: Int): Boolean {
        var counter = 0
        for (i in 0..4) {
            for (j in i+1..4) {
                if (List[i] == List[j] && List[i] == number) {
                    counter += 1
                }
                if (counter == 1) {
                    return true
                }
            }
        }
        return false
    }
    private fun SendFlagToDatabase(user: User,List: MutableList<Int>){
        var Verdict = getCombo(List)
        if(Verdict=="Coppia" && user.numbersRepetition == false){
            user.numbersRepetition == true
            user.score += 5
            myViewModel.setFlag(user)
        }
    }
}

