package com.example.rock_paper_scissor_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import nl.dionsegijn.konfetti.xml.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

class Final : AppCompatActivity() {

    private lateinit var tryAgain : Button
    private lateinit var exit : Button

    private var rounds : Int = 0
    private var wonRounds : Int = 0
    private var drawRounds : Int = 0
    private var lostRounds : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        var viewKonfetti : KonfettiView = findViewById(R.id.konfettiView)

        var party = Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
            position = Position.Relative(0.5, 0.3)
        )

        tryAgain = findViewById(R.id.button)
        exit = findViewById(R.id.button2)

        var result : TextView = findViewById(R.id.textView4)
        var score : TextView = findViewById(R.id.textView8)


        rounds = intent.getIntExtra("rounds",3)
        wonRounds = intent.getIntExtra("wonRounds",0)
        drawRounds = intent.getIntExtra("drawRounds",0)
        lostRounds = intent.getIntExtra("lostRounds",0)

        if (savedInstanceState != null){
            rounds = savedInstanceState.getInt("rounds")
            wonRounds = savedInstanceState.getInt("wonRounds")
            drawRounds = savedInstanceState.getInt("drawRounds")
            lostRounds = savedInstanceState.getInt("lostRounds")
        }



        score.text = "$wonRounds/$drawRounds/$lostRounds"

        if (drawRounds > rounds/2){
            result.text = "Awww man, that was close"
        }
        else{
            if(wonRounds == lostRounds){
                result.text = "Awww man , that was close"
            }
            else{
                if(wonRounds > lostRounds){
                    result.text = "Yay you won!"
                    viewKonfetti.start(party)
                }
                else{
                    result.text = "Sorry mate, you lost :<"
                }
            }
        }

        buttonListener()
    }

    fun buttonListener(){
        exit.setOnClickListener {
            finish()
        }
        tryAgain.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putInt("rounds",rounds)
        savedInstanceState.putInt("wonRounds",wonRounds)
        savedInstanceState.putInt("drawRounds",drawRounds)
        savedInstanceState.putInt("lostRounds",lostRounds)
        super.onSaveInstanceState(savedInstanceState)
    }
}