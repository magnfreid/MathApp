package com.example.mathapp

import android.os.Build
import android.os.Build.VERSION_CODES.TIRAMISU
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mathapp.databinding.ActivityResultsBinding
import com.example.mathapp.main.QuestionItem

class ResultsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.results)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val answeredQuestions = if (Build.VERSION.SDK_INT >= TIRAMISU) {
            intent.getSerializableExtra(
                "answeredQuestions",
                ArrayList<QuestionItem>()::class.java
            ) as List<QuestionItem>
        } else {
            intent.getSerializableExtra("questions") as List<QuestionItem>
        }
        Log.d("ANSWERED QUESTIONS LIST", "$answeredQuestions")
    }
}