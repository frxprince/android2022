package com.example.binaryprefix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InputPrefix : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_prefix)
        val btn1=findViewById<Button>(R.id.button4)
        val btn2=findViewById<Button>(R.id.button5)
        val btn3=findViewById<Button>(R.id.button6)
        val btn4=findViewById<Button>(R.id.button7)
        val intent= Intent()
        btn1.setOnClickListener(){
            intent.putExtra("prefix","kB");
            setResult(RESULT_OK,intent)
            finish()
        }
        btn2.setOnClickListener(){
            intent.putExtra("prefix","MB");
            setResult(RESULT_OK,intent)
            finish()
        }
        btn3.setOnClickListener(){
            intent.putExtra("prefix","GB");
            setResult(RESULT_OK,intent)
            finish()
        }
        btn4.setOnClickListener(){
            intent.putExtra("prefix","TB");
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}