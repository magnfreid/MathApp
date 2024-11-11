package com.example.dicegame

import kotlin.random.Random

class Dice() {


    fun rollD6(): Int {
        return Random.nextInt(1, 7)
    }

    fun rollD20(): Int {
        return Random.nextInt(1, 21)
    }

    fun roll(sides: Int): Int {
        return Random.nextInt(1, sides + 1)
    }

}