package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isEmpty
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityMainLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


class MainActivityLogin : AppCompatActivity() {
   private lateinit var binding:ActivityMainLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val forgetpass = findViewById<TextView>(R.id.forgetpass)



        // usign the binding we can't requare find the id from the xml

       binding.button.setOnClickListener {

           val N = binding.name.editText?.text.toString()
           if (N.isEmpty()) {
               Toast.makeText(this, "fill all the details", Toast.LENGTH_LONG).show()
           } else {

               Firebase.auth.createUserWithEmailAndPassword(
                   binding.email.editText?.text.toString(),
                   binding.password.editText?.text.toString()
               ).addOnCompleteListener {
                   if (it.isSuccessful) {
                       val intent = Intent(this, MainActivityQuiz::class.java)
                       startActivity(intent)
                       Toast.makeText(this, "user created", Toast.LENGTH_LONG).show()
                   } else {
                       Toast.makeText(this, "user not created", Toast.LENGTH_LONG).show()
                   }
               }
           }
       }
      //  val forgetpass = findViewById<TextView>(R.id.forgetpass)
       forgetpass.setOnClickListener {
           val intent = Intent(this,ForgetActivity::class.java)
           startActivity(intent)
       }
    }
}