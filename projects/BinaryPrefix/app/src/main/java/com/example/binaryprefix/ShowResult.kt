package com.example.binaryprefix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ShowResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_result)
        val txtdisplay=findViewById<TextView>(R.id.textView2)
        val btn=findViewById<Button>(R.id.button11)
        btn.setOnClickListener { finish() }
        txtdisplay.text=intent.getStringExtra("result")
    }
}