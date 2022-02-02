package com.example.rock_paper_scissor_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Game : AppCompatActivity() {

    private var rounds : Int = 0
    private var currentRound : Int = 0
    private var wonRounds : Int = 0
    private var drawRounds : Int = 0
    private var lostRounds : Int = 0

    private lateinit var rockB : Button
    private lateinit var paperB : Button
    private lateinit var scissorB : Button

    private lateinit var scoreboard : TextView
    private lateinit var roundview : TextView

    private var options = listOf<String>("rock","paper","scissor")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        rounds = intent.getIntExtra("rounds",3)

        rockB = findViewById(R.id.imageButton)
        paperB = findViewById(R.id.imageButton2)
        scissorB = findViewById(R.id.imageButton3)

        scoreboard = findViewById(R.id.textView2)
        roundview = findViewById(R.id.textView3)

        buttonListeners()
    }

    fun buttonListeners(){
        rockB.setOnClickListener {
            checkLogic("rock")

        }
        paperB.setOnClickListener {
            checkLogic("paper")

        }
        scissorB.setOnClickListener {
            checkLogic("scissor")

        }
    }

    fun checkLogic(inputB : String){
        if (inputB == options.random()){
            drawRounds+=1
        }
        if (inputB == "paper" && inputB){

        }


        //displaying function and iteration function

    }
}