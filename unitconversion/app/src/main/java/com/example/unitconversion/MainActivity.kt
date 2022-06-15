package com.example.unitconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1=findViewById<Button>(R.id.button)
        val btn2=findViewById<Button>(R.id.button2)
        val btn3=findViewById<Button>(R.id.button3)
        val txtinput=findViewById<EditText>(R.id.editTextNumber)
        val txtview=findViewById<TextView>(R.id.textView)

        btn1.setOnClickListener {
            txtview.text=" ${txtinput.text.toString().toDouble()*2.54} cm  "
        }
        btn2.setOnClickListener {
            txtview.text=" ${txtinput.text.toString().toDouble()/2.54} inch  "
        }
        btn3.setOnClickListener { finish() }
    }
}