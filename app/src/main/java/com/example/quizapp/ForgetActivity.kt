package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class ForgetActivity : AppCompatActivity() {

    // to access the Firebase
    private lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget2)



        val forgetemail = findViewById<EditText>(R.id.forgetemail)
        val forgetbtn = findViewById<Button>(R.id.forgetbtn)



        // For reset the passowrd into the firebase ..
        auth = FirebaseAuth.getInstance()
        forgetbtn.setOnClickListener {
            val fpass = forgetemail.text.toString()
            auth.sendPasswordResetEmail(fpass).addOnSuccessListener {
                Toast.makeText(this,"Check Your Email",Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                Toast.makeText(this,"wrong\nemail", Toast.LENGTH_LONG).show()
            }
        }




    }
}