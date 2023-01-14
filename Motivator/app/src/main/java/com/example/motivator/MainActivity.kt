package com.example.motivator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var caption:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val updateButton:Button=findViewById(R.id.activity_main_btn)
        updateButton.setOnClickListener{updateMessage()}
        name=findViewById(R.id.activity_main_et)
        caption=findViewById((R.id.motivate_text))

    }
    private fun updateMessage(){

        val username=name.text
        caption.text="Hey, $username "
        name.setText("")
        hideKeyboard()
    }
    private fun hideKeyboard(){
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(name.windowToken,0)
    }
}