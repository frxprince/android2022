package com.example.binaryprefix

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShowResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_result)
        val txtview=findViewById<TextView>(R.id.textView2)
        val btn=findViewById<Button>(R.id.button3)
        txtview.text= intent.getStringExtra("result")
        btn.setOnClickListener(){finish()}
    }
}