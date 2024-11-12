package com.example.mathapp.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mathapp.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class QuestionsAdapter(private val questions: List<QuestionItem>) :
    RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvQuestion: MaterialTextView = itemView.findViewById(R.id.tv_question)
        val etAnswer: TextInputEditText = itemView.findViewById(R.id.et_answer)
        val btnAnswer: MaterialButton = itemView.findViewById(R.id.btn_submit_answer)
        val tvUserAnswer: MaterialTextView = itemView.findViewById(R.id.tv_user_answer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_question, parent, false)
        return QuestionViewHolder(view)

    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val currentItem = questions[position]
        val questionString = "${currentItem.num1}${currentItem.operatorType}${currentItem.num2}?"
        holder.tvQuestion.text = questionString
        holder.btnAnswer.setOnClickListener {
            currentItem.userAnswer = holder.etAnswer.text.toString().toDouble()
            val userAnswerString = "Your answer: ${currentItem.userAnswer}"
            holder.tvUserAnswer.text = userAnswerString
        }
    }
}