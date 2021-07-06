package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.mobileprogrammingproject.R
import android.widget.Button
import android.widget.ImageView
import com.example.mobileprogrammingproject.databinding.FragmentMenuBinding
import com.example.mobileprogrammingproject.databinding.FragmentPlayBinding
import kotlinx.coroutines.delay
import java.util.*

class PlayFragment : Fragment() {
    private var _binding: FragmentPlayBinding? = null
    private val binding get() = _binding!!
    private val diceImages = mutableListOf<Int>()
    private lateinit var combo : String
    private lateinit var firstDice : ImageView
    private lateinit var secondDice : ImageView
    private lateinit var thirdDice : ImageView
    private lateinit var fourthDice : ImageView
    private lateinit var fifthDice : ImageView
    private lateinit var animation: Animation



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        val view = binding.root

        //logic...
        firstDice = binding.FirstRoll
        secondDice = binding.SecondRoll
        thirdDice = binding.ThirdRoll
        fourthDice = binding.FourthRoll
        fifthDice = binding.FifthRoll
        val ArrayDice = mutableListOf<ImageView>(firstDice,secondDice,thirdDice,fourthDice,fifthDice)
        val rollAndCheckButton = binding.RollerAndChecker
        rollAndCheckButton.setOnClickListener {
            for(i in 0..4){
                getRandomValue(ArrayDice[i])
                }
        }
        diceImages.add(R.drawable.ic_dice_one)
        diceImages.add(R.drawable.ic_dice_two)
        diceImages.add(R.drawable.ic_dice_three)
        diceImages.add(R.drawable.ic_dice_four)
        diceImages.add(R.drawable.ic_dice_five)
        diceImages.add(R.drawable.ic_dice_six)
        //initializing animation
        animation = AnimationUtils.loadAnimation(this.context,R.anim.shake_animation)

        return view
    }
    //gets a random value between one and six and sets the right dice image
    private fun getRandomValue(dice: ImageView?): Int {
        val random = Random().nextInt(6)
        dice?.startAnimation(animation)
        dice?.setImageResource(diceImages.elementAt(random))

        return random
    }
}

