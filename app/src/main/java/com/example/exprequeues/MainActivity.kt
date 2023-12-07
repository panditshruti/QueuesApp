package com.example.exprequeues

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.exprequeues.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var arrayList: ArrayList<Gk>
    private lateinit var db:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseDatabase.getInstance().reference.child("queues Questions")

        arrayList = arrayListOf()
        arrayList.add(Gk("India is a state",false))
        arrayList.add(Gk("India is a state", false))
        arrayList.add(Gk("Is the sky blue?", true))
        arrayList.add(Gk("Water boils at 100 degrees Celsius.", true))
        arrayList.add(Gk("What is the capital of France?", false))
        arrayList.add(Gk("Who painted the Mona Lisa?", true))
        arrayList.add(Gk("What is the largest planet in our solar system?", true))
        arrayList.add(Gk("Who wrote the novel 'Pride and Prejudice'?", true))
        arrayList.add(Gk("What year did World War II end?", false))
        arrayList.add(Gk("What is the chemical symbol for gold?", true))
        arrayList.add(Gk("What is the tallest mountain in the world?", false))
        arrayList.add(Gk("Who discovered penicillin?", true))
        arrayList.add(Gk("What is the capital of Japan?", true))
        arrayList.add(Gk("Who painted 'The Starry Night'?", true))
        arrayList.add(Gk("What is the largest ocean on Earth?", false))
        arrayList.add(Gk("What is the square root of 144?", true))
        arrayList.add(Gk("Who is the author of 'To Kill a Mockingbird'?", true))
        arrayList.add(Gk("What is the symbol for the chemical element oxygen?", true))
        arrayList.add(Gk("What is the currency of Brazil?", false))
        arrayList.add(Gk("Who wrote 'Romeo and Juliet'?", true))
        arrayList.add(Gk("What is the largest organ in the human body?", true))
        arrayList.add(Gk("What is the capital of Australia?", false))
        arrayList.add(Gk("Who invented the telephone?", true))
        arrayList.add(Gk("What is the chemical symbol for sodium?", true))


        for (a in 0 until arrayList.size){
            db.child(a.toString()).setValue(Gk(arrayList[a].question,arrayList[a].answer))
        }



        var userScore = 0
        var questionIndex = 0
        binding.tvQuestion.text = arrayList[questionIndex].question

        binding.nextbtn.setOnClickListener {

            var selectedAnswer = false
            binding.tvQuestion.text = arrayList[questionIndex].question

            if (binding.trueCheckBox.isChecked){
                selectedAnswer = true
            }
             if (binding.falseCheckBox.isChecked){
                selectedAnswer = false
            }

            if (selectedAnswer == arrayList[questionIndex].answer){

                userScore++

                binding.rightScore.visibility = View.VISIBLE
                binding.rightScore.text = userScore.toString()
            }

            questionIndex++
        }

        binding.falseCheckBox.setOnClickListener {
            binding.trueCheckBox.isChecked = false
        }
  binding.trueCheckBox.setOnClickListener {
            binding.falseCheckBox.isChecked = false
        }

    }
}