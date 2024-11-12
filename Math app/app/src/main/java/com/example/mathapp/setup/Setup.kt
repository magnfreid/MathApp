package com.example.mathapp.setup

import com.example.mathapp.main.QuestionItem
import kotlin.random.Random

object Setup {
    const val ADDITION = "+"
    const val SUBTRACTION = "-"
    const val MULTIPLY = "x"
    const val DIVISION = "/"
    const val MIXED = "MIXED"
    const val MAX_AMOUNT = 20
    const val MIN_AMOUNT = 5
    var chosenType: String = ADDITION
    var questionAmount: Int = 0

    fun generateQuestions(): ArrayList<QuestionItem> {
        val questions = ArrayList<QuestionItem>()
        repeat(questionAmount) {
            val random1 = (1..100).random()
            val random2 = (1..100).random()
            val (num1, num2) = if (random1 >= random2) {
                random1 to random2
            } else {
                random2 to random1
            }
            val operator = if (chosenType == MIXED) getRandomType() else chosenType
            val question = QuestionItem(
                num1, num2,
                operator,
                getAnswer(num1, num2, operator),
                null
            )
            questions.add(question)
        }
        return questions
    }

    private fun getRandomType(): String {
        val operators = listOf(
            ADDITION,
            SUBTRACTION,
            MULTIPLY,
            DIVISION
        )
        return operators[Random.nextInt(operators.size)]
    }

    private fun getAnswer(num1: Int, num2: Int, operator: String): Double {
        return when (operator) {
            ADDITION -> num1.toDouble() + num2.toDouble()
            SUBTRACTION -> num1.toDouble() - num2.toDouble()
            MULTIPLY -> num1.toDouble() * num2.toDouble()
            DIVISION -> num1.toDouble() / num2.toDouble()
            else -> 0.0
        }
    }
}