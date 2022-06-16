package com.example.binaryprefix

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        setContentView(R.layout.activity_welcome)
        val btn=findViewById<ImageButton>(R.id.imageButton)
        btn.setOnClickListener(){
            val i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }
}