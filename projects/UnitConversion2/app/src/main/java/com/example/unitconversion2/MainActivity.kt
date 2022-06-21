package com.example.unitconversion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtinput=findViewById<EditText>(R.id.editTextNumber)
        val r_cm2inch=findViewById<RadioButton>(R.id.radioButton)
        val r_inch2cm=findViewById<RadioButton>(R.id.radioButton2)
        val btn=findViewById<Button>(R.id.button)
        val txtoutput=findViewById<TextView>(R.id.textView)
     btn.setOnClickListener {
     var inputvalue=txtinput.text.toString().toDouble()
     var outputvalue:Double=if(r_cm2inch.isChecked) inputvalue/2.54 else inputvalue*2.54
     var suffix=if(r_cm2inch.isChecked) "inch" else "cm"
         txtoutput.text="%.2f".format(outputvalue) + "   $suffix "
     }
    }
}