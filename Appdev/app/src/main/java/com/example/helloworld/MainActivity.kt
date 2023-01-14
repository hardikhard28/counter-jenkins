package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("test","I am bro tag")
    }

    override fun onStart() {
        super.onStart()
        Log.i("onstart","I am the on start tag")

    }
    override fun onPause() {
        super.onPause()
        Log.i("onstart","I am the on start tag")

    }
    override fun onResume() {
        super.onResume()
        Log.i("onstart","I am the on start tag")

    }
}
