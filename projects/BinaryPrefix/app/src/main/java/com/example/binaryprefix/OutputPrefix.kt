package com.example.binaryprefix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OutputPrefix : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output_prefix)

        val intent= Intent()
        val btnkB=findViewById<Button>(R.id.button7)
        val btnMB=findViewById<Button>(R.id.button8)
        val btnGB=findViewById<Button>(R.id.button9)
        val btnTB=findViewById<Button>(R.id.button10)
        btnkB.setOnClickListener {
            intent.putExtra("prefix","KiB"); setResult(RESULT_OK,intent); finish()
        }
        btnMB.setOnClickListener {
            intent.putExtra("prefix","MiB"); setResult(RESULT_OK,intent); finish()
        }
        btnGB.setOnClickListener {
            intent.putExtra("prefix","GiB"); setResult(RESULT_OK,intent); finish()
        }
        btnTB.setOnClickListener {
            intent.putExtra("prefix","TiB"); setResult(RESULT_OK,intent); finish()
        }
    }
}