package com.example.rock_paper_scissor_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var rounds : Int = 3 // initiating the variable with a dummy value
    private lateinit var input3 : Button
    private lateinit var input5 : Button
    private lateinit var input7 : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input3 = findViewById(R.id.button3)
        input5 = findViewById(R.id.button5)
        input7 = findViewById(R.id.button7)

        buttonListeners()

    }

    fun buttonListeners(){

        var intent = Intent(this,Game::class.java)

        input3.setOnClickListener {
            rounds = 3
            intent.putExtra("score",rounds)
            startActivity(intent)
            finish()
        }

        input5.setOnClickListener {
            rounds = 5
            intent.putExtra("score",rounds)
            startActivity(intent)
            finish()
        }

        input7.setOnClickListener {
            rounds = 7
            intent.putExtra("score",rounds)
            startActivity(intent)
            finish()
        }
    }
}