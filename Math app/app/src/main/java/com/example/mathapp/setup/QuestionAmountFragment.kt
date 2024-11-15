package com.example.mathapp.setup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mathapp.QuestionsActivity
import com.example.mathapp.databinding.FragmentQuestionAmountBinding

class QuestionAmountFragment : Fragment() {
    private lateinit var binding: FragmentQuestionAmountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionAmountBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val questionString =
            binding.tvAmount.text.toString() + " (${Setup.MIN_AMOUNT}-${Setup.MAX_AMOUNT})"
        binding.tvAmount.text = questionString
        binding.btnQuestionAmount.setOnClickListener {
            val amount = binding.etAmount.text.toString().toInt()
            if (amount in Setup.MIN_AMOUNT..Setup.MAX_AMOUNT) {
                Setup.questionAmount = amount
                val newIntent = Intent(view.context, QuestionsActivity::class.java)
                val questions = Setup.generateQuestions()
                newIntent.putExtra("questions", questions)
                startActivity(newIntent)
            } else {
                Toast.makeText(
                    view.context,
                    "You need to select between ${Setup.MIN_AMOUNT} and ${Setup.MAX_AMOUNT} questions!",
                    Toast.LENGTH_SHORT

                ).show()
            }
        }
    }
}