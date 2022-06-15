package com.example.binaryprefix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TargetPrefix : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target_prefix)
        val btn1=findViewById<Button>(R.id.button9)
        val btn2=findViewById<Button>(R.id.button8)
        val btn3=findViewById<Button>(R.id.button10)
        val btn4=findViewById<Button>(R.id.button11)
        val intent= Intent()
        btn1.setOnClickListener(){
            intent.putExtra("prefix","KiB");
            setResult(RESULT_OK,intent)
            finish()
        }
        btn2.setOnClickListener(){
            intent.putExtra("prefix","MiB");
            setResult(RESULT_OK,intent)
            finish()
        }
        btn3.setOnClickListener(){
            intent.putExtra("prefix","GiB");
            setResult(RESULT_OK,intent)
            finish()
        }
        btn4.setOnClickListener(){
            intent.putExtra("prefix","TiB");
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}