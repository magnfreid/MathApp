package com.example.dicegame

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var rollButton: Button
    private lateinit var display: TextView
    private val dice = Dice()
    private val diceRolls = mutableListOf<Int>()


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rollButton = findViewById(R.id.rollButton)
        display = findViewById(R.id.displayTextView)
        val diceImageViews = listOf<ImageView>(
            findViewById(R.id.dice1ImageView),
            findViewById(R.id.dice2ImageView),
            findViewById(R.id.dice3ImageView),
            findViewById(R.id.dice4ImageView),
            findViewById(R.id.dice5ImageView),
        )

        val diceImages = listOf(
            ResourcesCompat.getDrawable(resources, R.drawable.dice_1, null),
            ResourcesCompat.getDrawable(resources, R.drawable.dice_2, null),
            ResourcesCompat.getDrawable(resources, R.drawable.dice_3, null),
            ResourcesCompat.getDrawable(resources, R.drawable.dice_4, null),
            ResourcesCompat.getDrawable(resources, R.drawable.dice_5, null),
            ResourcesCompat.getDrawable(resources, R.drawable.dice_6, null)
        )

        rollButton.setOnClickListener {
            for (diceImageView in diceImageViews) {
                val roll = dice.rollD6()
                diceRolls.add(roll)
                diceImageView.setImageDrawable(diceImages[roll - 1])
            }
            display.text = checkRolls()
            diceRolls.clear()
        }


    }


    /**
     * Counts the how many dice lands on the same number and returns a string with the result
     */
    private fun checkRolls(): String {
        val sameDiceCount = diceRolls.groupingBy { it }.eachCount()
        return when {
            sameDiceCount.containsValue(5) -> "Five of a kind!"
            sameDiceCount.containsValue(4) -> "Four of a kind!"
            sameDiceCount.containsValue(3) && sameDiceCount.containsValue(2) -> "Full House!"
            sameDiceCount.containsValue(3) -> "Three of a kind!"
            sameDiceCount.filter { it.value == 2 }.size == 2 -> "Two pairs!"
            sameDiceCount.containsValue(2) -> "One pair!"
            else -> "Nothing special!"
        }

    }


}


/*
## Skapa en tärning
### Del 1
1. Börja med att slumpa fram ett tal mellan 1 och 6. Använd Log.d för att skriva ut resultatet.
2. Skapa en `TextView` och visa upp resultatet av det slumpade tärningsvärdet i rutan
3. Skapa en knapp
4. Varje gång knappen trycks ska ett nytt värde slumpas fram och detta värde visas upp i din `TextView`

### Del 2 - Skapa en mer avancerad tärning

1. Skapa en `EditText`  (plaintext) där användaren kan skriva in hur många sidor tärningen ska ha.
2. ta värdet användaren har skrivit in och ändra så att du slumpar ett tal från 1 upp till det angivna värdet i stället.

### Del 3 - pröva att göra en grafisk tärning - extra

1. Prova att skapa en `Imageview` och ladda ner 6 bilder för de olika tärningssidorna. Lägg dessa bilder i mappen `drawable`.
2. Försök att skriva kod så att en av bilderna visas i din imageview.
(googla tex på: “android kotlin set image in imageview”)
3. Sätt rätt bild i din `Imageview` beroende på det värde som slumpats fram

### Del 4 - utveckla tärningen - extra

Använd den tärning du skapat för att göra något slags enkelt tärningsspel!*/
