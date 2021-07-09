package com.example.mobileprogrammingproject
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobileprogrammingproject.data.User
import com.example.mobileprogrammingproject.data.UserViewModel
import com.example.mobileprogrammingproject.databinding.FragmentResultsBinding
import com.example.mobileprogrammingproject.fragments.PlayFragmentArgs

class ResultsFragment : Fragment() {
    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    private lateinit var myViewModel: UserViewModel
    private val args: ResultsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //binding section
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        val view = binding.root

        //logic...
        val info = args.currentRollsNumberArg
        binding.GoToNextRollButton.setOnClickListener {
            val action = ResultsFragmentDirections.actionResultsFragmentToPlayFragment(info)
            findNavController().navigate(action)
        }
        myViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        return view
    }
}