package com.example.counterapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var startNumInput: EditText
    private lateinit var resultNum: TextView
    private lateinit var interval: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val submitStartButton: Button = findViewById(R.id.submitStartNum)
        val submitRandomButton: Button = findViewById(R.id.randomStartNumBtn)
        val incrementBtn: Button = findViewById(R.id.increment_btn)
        val decrementBtn: Button = findViewById(R.id.decrement_btn)
        submitStartButton.setOnClickListener { updateStartNum() }
        incrementBtn.setOnClickListener { handleIncrement() }
        decrementBtn.setOnClickListener { handleDecrement() }
        submitRandomButton.setOnClickListener { handleRandomStartNum() }
        startNumInput = findViewById(R.id.startNumInput)
        resultNum = findViewById(R.id.resultNumTv)
        interval = findViewById(R.id.intervalEt)


    }

    private fun updateStartNum() {
        if(startNumInput.text.toString()==""){
            resultNum.text="10"
        }
        else{
            resultNum.text = startNumInput.text
            startNumInput.setText("")
        }
        hideKeyboard()

    }

    private fun handleIncrement() {
        var currentNum=resultNum.text.toString().toInt()
        if(interval.text.toString()==""){
            currentNum += 1

        }else{
            currentNum+=interval.text.toString().toInt()
        }
        resultNum.text=currentNum.toString()

        hideKeyboard()

    }

    private fun handleDecrement() {
        var currentNum=resultNum.text.toString().toInt()
        if(interval.text.toString()==""){
            currentNum -= 1

        }else{
            currentNum-=interval.text.toString().toInt()
        }
        resultNum.text=currentNum.toString()

        hideKeyboard()

    }

    private fun handleRandomStartNum() {
        val randomNum = (-100..100).random()
        resultNum.text=randomNum.toString()
    }
    private fun hideKeyboard(){
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(resultNum.windowToken, 0)
    }

}