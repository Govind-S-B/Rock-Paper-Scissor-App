package com.example.rock_paper_scissor_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class Game : AppCompatActivity() {

    private var rounds : Int = 0
    private var currentRound : Int = 1
    private var wonRounds : Int = 0
    private var drawRounds : Int = 0
    private var lostRounds : Int = 0

    private lateinit var rockB : ImageButton
    private lateinit var paperB : ImageButton
    private lateinit var scissorB : ImageButton

    private lateinit var scoreboard : TextView
    private lateinit var roundview : TextView

    private var options = listOf("rock","paper","scissor")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        rounds = intent.getIntExtra("rounds",3)

        rockB = findViewById(R.id.imageButton)
        paperB = findViewById(R.id.imageButton2)
        scissorB = findViewById(R.id.imageButton3)

        scoreboard = findViewById(R.id.textView2)
        roundview = findViewById(R.id.textView3)

        roundview.text = "ROUND : $currentRound/$rounds"

        // setting value of things from save instance
        if (savedInstanceState != null){
            rounds = savedInstanceState.getInt("rounds")
            currentRound = savedInstanceState.getInt("currentRound")
            wonRounds = savedInstanceState.getInt("wonRounds")
            drawRounds = savedInstanceState.getInt("drawRounds")
            lostRounds = savedInstanceState.getInt("lostRounds")
        }

        // initial value setting to display
        scoreboard.text = "W/D/L : $wonRounds/$drawRounds/$lostRounds"
        roundview.text = "ROUND : $currentRound/$rounds"


        buttonListeners()
    }

    fun buttonListeners(){
        rockB.setOnClickListener {
            checkLogic("rock") // maybe optimise this by getting the rock paper scissor string directly from button , check properties of imgButton

        }
        paperB.setOnClickListener {
            checkLogic("paper")

        }
        scissorB.setOnClickListener {
            checkLogic("scissor")

        }
    }

    fun checkLogic(inputB : String){
        var computerInput = options.random()

        // very inefficient way to program the logic , ask ambro chetan for ideas to make this expandable to new objects too like say a man or something else
        if (inputB == "rock"){
            if (computerInput == "rock"){
                drawRounds +=1
            }
            if (computerInput == "paper"){
                lostRounds +=1
            }
            if (computerInput == "scissor"){
                wonRounds +=1
            }
        }
        if (inputB == "paper"){
            if (computerInput == "rock"){
                wonRounds +=1
            }
            if (computerInput == "paper"){
                drawRounds +=1
            }
            if (computerInput == "scissor"){
                lostRounds +=1
            }
        }
        if (inputB == "scissor"){
            if (computerInput == "rock"){
                lostRounds += 1
            }
            if (computerInput == "paper"){
                wonRounds +=1
            }
            if (computerInput == "scissor"){
                drawRounds += 1
            }
        }

        roundManager()

    }

    fun roundManager(){
        if (currentRound < rounds){
            scoreboard.text = "W/D/L : $wonRounds/$drawRounds/$lostRounds"
            currentRound +=1
            roundview.text = "ROUND : $currentRound/$rounds"
        }

        else{
            var intent = Intent(this,Final::class.java)
            intent.putExtra("rounds",rounds)
            intent.putExtra("wonRounds",wonRounds)
            intent.putExtra("drawRounds",drawRounds)
            intent.putExtra("lostRounds",lostRounds)
            startActivity(intent)
            finish()
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putInt("rounds",rounds)
        savedInstanceState.putInt("currentRound",currentRound)
        savedInstanceState.putInt("wonRounds",wonRounds)
        savedInstanceState.putInt("drawRounds",drawRounds)
        savedInstanceState.putInt("lostRounds",lostRounds)
        super.onSaveInstanceState(savedInstanceState)
    }
}