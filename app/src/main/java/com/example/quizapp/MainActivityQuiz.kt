package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainLoginBinding
import com.example.quizapp.databinding.ActivityMainQuizBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivityQuiz : AppCompatActivity() {

    private lateinit var binding:ActivityMainQuizBinding
    private lateinit var list:ArrayList<QuestionModel>
    private var count:Int = 0
    private var score:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list= ArrayList<QuestionModel>()


        // get the question from the firebase
        Firebase.firestore.collection("santu")
            .get().addOnSuccessListener {
            doct->
            list.clear()
            for(i in doct.documents)
            {
                var questionModel= i.toObject(QuestionModel::class.java)
                list.add(questionModel!!)

            }
            binding.question.setText(list.get(0).question)
            binding.option1.setText(list.get(0).option1)
            binding.option2.setText(list.get(0).option2)
            binding.option3.setText(list.get(0).option3)
            binding.option4.setText(list.get(0).option4)
        }
        // check the currect option as well as increase the score

            fun nextData(i: String) {
            if(count<list.size) {
                if (list.get(count).Ans.equals(i)) {
                    score++
                }
            }
            count++
            if (count >=list.size) {
                val intent = Intent(this, MainActivityScore::class.java)
                intent.putExtra("SCORE",score)
                startActivity(intent)
                finish()
            }
            else {
                binding.question.setText(list.get(count).question)
                binding.option1.setText(list.get(count).option1)
                binding.option2.setText(list.get(count).option2)
                binding.option3.setText(list.get(count).option3)
                binding.option4.setText(list.get(count).option4)
            }
        }
        // to fatch the options
        binding.option1.setOnClickListener {
            nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener {
            nextData(binding.option4.text.toString())
        }



    }
}