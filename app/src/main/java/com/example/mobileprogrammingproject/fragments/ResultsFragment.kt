package com.example.mobileprogrammingproject
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobileprogrammingproject.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {
    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    private val args: ResultsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //binding section
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        val view = binding.root

        //logic...
        val info = args.currentRollsNumberArg
        var Score = args.totalScore
        var DoubleBool = args.doubleBool
        var TrisBool = args.trisBool
        var quaterBool = args.quaterBool
        var yahtzeeBool = args.yahtzeeBool
        var FourASCBool = args.fourASCBool
        var FiveASCBool = args.fiveASCBool
        var chanceBool = args.chanceBool
        var BonusBool = args.bonusBool
        var FullBool = args.fullBool
        var lastcombo = args.lastCombo2
        var x = args.noRoll

        if(DoubleBool){
            binding.CoppiaCheck.visibility = View.VISIBLE
        }
        if(TrisBool){
            binding.TrisCheck.visibility = View.VISIBLE
        }
        if(quaterBool){
            binding.QuaterCheck.visibility = View.VISIBLE
        }
        if(yahtzeeBool){
            binding.YahtzeeCheck.visibility = View.VISIBLE
        }
        if(FourASCBool){
            binding.ScalaDa4Check.visibility = View.VISIBLE
        }
        if(FiveASCBool){
            binding.ScalaDa5Check.visibility = View.VISIBLE
        }
        if(chanceBool){
            binding.ChanceCheck.visibility = View.VISIBLE
        }
        if(BonusBool){
            binding.BonusCheck.visibility = View.VISIBLE
        }
        if(FullBool){
            binding.FullCheck.visibility = View.VISIBLE
        }
        binding.RealScore.text = Score.toString()



        binding.GoToNextRollButton.setOnClickListener {
            val action = ResultsFragmentDirections.actionResultsFragmentToPlayFragment(info,Score,DoubleBool,TrisBool,quaterBool,yahtzeeBool,FourASCBool,FiveASCBool,FullBool,chanceBool,BonusBool,lastCombo1 = lastcombo,noRoll = x)
            findNavController().navigate(action)
        }

        return view
    }
}