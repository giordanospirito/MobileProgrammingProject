package com.example.mobileprogrammingproject
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobileprogrammingproject.databinding.FragmentPlayBinding
import com.example.mobileprogrammingproject.databinding.FragmentResultsBinding
import com.example.mobileprogrammingproject.databinding.FragmentSettingsBinding

class ResultsFragment : Fragment() {
    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //binding section
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        val view = binding.root

        //logic...

        binding.GoToNextRollButton.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment_to_playFragment3)
        }


        return view
    }
}