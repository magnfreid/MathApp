package com.example.mathapp.main

data class QuestionItem(
    val num1: Int,
    val num2: Int,
    val operatorType: Int,
    val isAnswered: Boolean,
    val answer: Int?
)