package com.example.coinflipapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    private lateinit var coinImage: ImageView
    private lateinit var totalcount: TextView
    private lateinit var headsCount: TextView
    private lateinit var tailsCount: TextView
    private lateinit var headsProgressBar: ProgressBar
    private lateinit var tailsProgressBar: ProgressBar
    private lateinit var headsPerc: TextView
    private lateinit var tailsPerc: TextView
    private lateinit var flip_sumnum_ev: EditText

    private var heads = 0
    private var tails = 0
    private var total = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val switchsim: SwitchCompat = findViewById(R.id.sim_switch)
        val flipBtn: Button = findViewById(R.id.flipButton)
        val resetBtn: Button = findViewById(R.id.resetButton)
        val simBtn: Button = findViewById(R.id.Simulate_btn)

        switchsim.setOnCheckedChangeListener { buttonView, isChecked -> enableSim(isChecked) }
        flipBtn.setOnClickListener { flip() }
        resetBtn.setOnClickListener { reset() }
        simBtn.setOnClickListener { sim() }

        coinImage = findViewById(R.id.main_activity_head_iv)
        totalcount = findViewById(R.id.total_flip_text)
        headsCount = findViewById(R.id.total_head_tv)
        tailsCount = findViewById(R.id.total_tails_tv)
//        headsProgressBar = findViewById(R.id.headsProgressbar)
//        tailsProgressBar = findViewById(R.id.tails_progressBar)
//        headsPerc = findViewById(R.id.headPerc_tv)
//        tailsPerc = findViewById(R.id.total_tails_tv)
        flip_sumnum_ev = findViewById(R.id.flip_sumnum_ev)


    }

    private fun enableSim(onState: Boolean) {

    }

    private fun flip() {
        var randomNum = (0..1).random()
        if (randomNum == 0) {
            update("Heads")
        } else {
            update("Tails")
        }
    }

    private fun update(coinValue: String) {
        if (coinValue == "Heads") {
            heads++
            coinImage.setImageResource(R.drawable.ic_head)
            headsCount.text = "Total head $heads"
            total++
            totalcount.text = "Total flips $total"
        } else {
            tails++
            coinImage.setImageResource(R.drawable.ic_tails)
            tailsCount.text = "Total head $tails"
            total++
            totalcount.text = "Total flips $total"

        }

    }

    private fun reset() {}
    private fun sim() {}
}
