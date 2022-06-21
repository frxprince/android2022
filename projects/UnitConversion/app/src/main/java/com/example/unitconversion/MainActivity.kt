package com.example.unitconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtinput=findViewById<EditText>(R.id.editTextNumber)
        val btncm2inch=findViewById<Button>(R.id.button)
        val btninch2cm=findViewById<Button>(R.id.button2)
        val btnexit=findViewById<Button>(R.id.button3)
        val txtoutput=findViewById<TextView>(R.id.textView)

        btncm2inch.setOnClickListener {
/*
            var cm:Double
           if(txtinput.text.isEmpty())
           {
               cm=0.0
           }else{
               cm=txtinput.text.toString().toDouble()
           }
  */
            var cm:Double=if(txtinput.text.isEmpty())0.0 else txtinput.text.toString().toDouble()
            var inch=cm/2.54
         //   txtoutput.text=inch.toString()+ " inch"
            txtoutput.text="%.3f".format(inch) + resources.getString(R.string.inch)
         //txtoutput.text=" $inch   inch"
        //    txtoutput.text=" ${cm/2.54}   inch"
        //    txtoutput.text=" ${txtinput.text.toString().toDouble()/2.54}   inch"
        }
        btninch2cm.setOnClickListener { txtoutput.text=" ${txtinput.text.toString().toDouble()*2.54}  ${resources.getString(
            R.string.cm)}" }
        btnexit.setOnClickListener { finish() }
    }
}