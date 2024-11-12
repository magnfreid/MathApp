package com.example.mathapp.setup

import com.example.mathapp.main.QuestionItem

object Setup {
    const val ADDITION = 0
    const val SUBTRACTION = 1
    const val MULTIPLY = 2
    const val DIVISION = 3
    const val MIXED = 4
    const val MAX_AMOUNT = 20
    const val MIN_AMOUNT = 5
    var chosenType: Int = ADDITION
    var questionAmount: Int = 1

    fun generateQuestions(): List<QuestionItem> {
        val questions = mutableListOf<QuestionItem>()
        repeat(questionAmount) {
            val random1 = (1..100).random()
            val random2 = (1..100).random()
            val (num1, num2) = if (random1 >= random2) {
                random1 to random2
            } else {
                random2 to random1
            }
            val question = QuestionItem(
                num1, num2,
                if (chosenType == MIXED) (ADDITION..DIVISION).random() else chosenType,
                false,
                null
            )
            questions.add(question)
        }
        return questions
    }
}