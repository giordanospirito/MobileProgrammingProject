package com.example.mobileprogrammingproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.mobileprogrammingproject.R
import android.widget.ImageView
import com.example.mobileprogrammingproject.databinding.FragmentPlayBinding
import java.util.*

class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null
    private val binding get() = _binding!!
    private val diceImages = mutableListOf<Int>()
    private lateinit var animation: Animation

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //binding section
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        val view = binding.root

        //roll section
        val rollResults = mutableListOf<Int>()
        val arrayDices = mutableListOf(binding.FirstRoll,binding.SecondRoll,binding.ThirdRoll,binding.FourthRoll,binding.FifthRoll)
        binding.RollerAndChecker.setOnClickListener {
            rollResults.removeAll(listOf(1,2,3,4,5,6))
            for(i in 0..4){
                getRandomValue(arrayDices[i],rollResults)
                }
            binding.Combo.text = rollResults.toString()
        }
        diceImagesAdder(diceImages)
        animation = AnimationUtils.loadAnimation(this.context,R.anim.shake_animation)

        //return section
        return view
    }

    //functions
    private fun getRandomValue(dice: ImageView?,list: MutableList<Int>){
        val random = Random().nextInt(6)
        dice?.startAnimation(animation)
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
}
