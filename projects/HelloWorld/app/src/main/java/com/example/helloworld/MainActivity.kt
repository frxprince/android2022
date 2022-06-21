package com.example.helloworld

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnHello= findViewById<Button>(R.id.button1)
        val txtDisplay=findViewById<TextView>(R.id.text_title)
        btnHello.setOnClickListener {
            Log.v("MyProgram","Hello World!!!!!")
            txtDisplay.text="Hello World!!!"
        }
    }
}