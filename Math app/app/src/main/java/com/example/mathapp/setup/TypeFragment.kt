package com.example.mathapp.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mathapp.R
import com.example.mathapp.databinding.FragmentTypeBinding

class TypeFragment : Fragment() {
    private lateinit var binding: FragmentTypeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTypeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddition.setOnClickListener {
            Setup.chosenType = Setup.ADDITION
            nextFragment()
        }
        binding.btnSubtraction.setOnClickListener {
            Setup.chosenType = Setup.SUBTRACTION
            nextFragment()
        }
        binding.btnMultiplication.setOnClickListener {
            Setup.chosenType = Setup.MULTIPLY
            nextFragment()
        }
        binding.btnDivision.setOnClickListener {
            Setup.chosenType = Setup.DIVISION
            nextFragment()
        }
        binding.btnMixed.setOnClickListener {
            Setup.chosenType = Setup.MIXED
            nextFragment()
        }
    }

    private fun nextFragment() {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, QuestionAmountFragment())
            .addToBackStack(null)
            .commit()
    }

}