package com.example.unitconversion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtinput=findViewById<EditText>(R.id.editTextNumber)
        val inch2cm=findViewById<RadioButton>(R.id.radioButton)
        val cm2inch=findViewById<RadioButton>(R.id.radioButton2)
        val btn=findViewById<Button>(R.id.button)
        val txtview=findViewById<TextView>(R.id.textView)
        btn.setOnClickListener {
          var input= txtinput.text.toString().toDouble()
          var ans:Double= if(inch2cm.isChecked) input *2.54 else input/ 2.54
            txtview.text="%.4f".format(ans)
          var suffix=   if(inch2cm.isChecked) " cm" else " inch"
            txtview.text="%.4f".format(ans) + " $suffix"
        }
    }
}