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

        binding.GoToNextRollButton.setOnClickListener {
            val action = ResultsFragmentDirections.actionResultsFragmentToPlayFragment(args.currentRollsNumberArg)
            findNavController().navigate(action)
            findNavController().popBackStack(R.id.resultsFragment, true)
        }

        myViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        var myUser = User(
            0,
            "Federico",
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false)

        return view
    }
}