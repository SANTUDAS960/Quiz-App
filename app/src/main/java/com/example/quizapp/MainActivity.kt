package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.os.Handler
import android.view.Window
import android.widget.Toast
import androidx.core.os.postDelayed
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed(2000)
        {
            // if user login
            if (Firebase.auth.currentUser!=null) {
                val intent = Intent(this, MainActivityQuiz::class.java)
                startActivity(intent)
                Toast.makeText(this,"You are already login in the Quiz app",Toast.LENGTH_LONG).show()
              //  finish()   it's terminate the condition all time
            } else
            {
                val intent = Intent(this,MainActivityLogin::class.java)
                // its takes the value from one layout to another layout
                intent.putExtra("MODE","SINGUP")
                startActivity(intent)
            }


        }
    }
}