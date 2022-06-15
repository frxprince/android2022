package com.example.binaryprefix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val btn=findViewById<ImageButton>(R.id.imageButton)
        btn.setOnClickListener(){
            val i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }

    }
}