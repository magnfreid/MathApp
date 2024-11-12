package com.example.mathapp.main
import java.io.Serializable

data class QuestionItem(
    val num1: Int,
    val num2: Int,
    val operatorType: String,
    var correctAnswer: Double,
    var userAnswer: Double?
) : Serializable