package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.quizapp.databinding.ActivityMainQuizBinding
import com.example.quizapp.databinding.ActivityMainScoreBinding

class MainActivityScore : AppCompatActivity() {
    private lateinit var binding: ActivityMainScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.score.setText(" Congrats !!! your Score is ${intent.getIntExtra("SCORE",0)}"+"\t")


    }
}