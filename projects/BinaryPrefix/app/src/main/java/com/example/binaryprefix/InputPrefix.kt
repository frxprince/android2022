package com.example.binaryprefix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InputPrefix : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_prefix)
        val intent= Intent()
        val btnkB=findViewById<Button>(R.id.button3)
        val btnMB=findViewById<Button>(R.id.button4)
        val btnGB=findViewById<Button>(R.id.button5)
        val btnTB=findViewById<Button>(R.id.button6)
        btnkB.setOnClickListener {
            intent.putExtra("prefix","kB"); setResult(RESULT_OK,intent); finish()
        }
        btnMB.setOnClickListener {
            intent.putExtra("prefix","MB"); setResult(RESULT_OK,intent); finish()
        }
        btnGB.setOnClickListener {
            intent.putExtra("prefix","GB"); setResult(RESULT_OK,intent); finish()
        }
        btnTB.setOnClickListener {
            intent.putExtra("prefix","TB"); setResult(RESULT_OK,intent); finish()
        }



    }
}