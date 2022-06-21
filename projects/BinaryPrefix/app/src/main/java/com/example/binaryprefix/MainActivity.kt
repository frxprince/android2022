package com.example.binaryprefix

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        setContentView(R.layout.activity_main)
        val btnInputPrefix=findViewById<Button>(R.id.button)
        val btnOutputPrefix=findViewById<Button>(R.id.button2)
        val txtdisplay=findViewById<TextView>(R.id.textView)
        val txtinput=findViewById<EditText>(R.id.editTextNumber)
        var bytevalue:Double=0.0
    val InputPrefixResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result:ActivityResult->
        if(result.resultCode==Activity.RESULT_OK){
            bytevalue =  when(result.data!!.getStringExtra("prefix")){
               "kB"->txtinput.text.toString().toDouble()* Math.pow(10.0,3.0)
                "MB"->txtinput.text.toString().toDouble()* Math.pow(10.0,6.0)
                "GB"->txtinput.text.toString().toDouble()* Math.pow(10.0,9.0)
                "TB"->txtinput.text.toString().toDouble()* Math.pow(10.0,12.0)
                else -> 0.0
            }
            txtdisplay.text=  DecimalFormat("#,###,###").format(bytevalue)+" Bytes"
        }
    }
    val OutputPrefixResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result:ActivityResult->
        if(result.resultCode==Activity.RESULT_OK){
            var ans:String=when(result.data!!.getStringExtra("prefix")){
                "KiB"->"${bytevalue / Math.pow(2.0,10.0)} KiB"
                "MiB"->"${bytevalue / Math.pow(2.0,20.0)} MiB"
                "GiB"->"${bytevalue / Math.pow(2.0,30.0)} GiB"
                "TiB"->"${bytevalue / Math.pow(2.0,40.0)} TiB"
                else ->"Error"
            }
            Log.v("answer",ans)
            val I=Intent(this,ShowResult::class.java)
            I.putExtra("result",ans)
            startActivity(I)
        }
    }

    btnOutputPrefix.setOnClickListener {
        val I=Intent(this,OutputPrefix::class.java)
        OutputPrefixResult.launch(I)
    }

    btnInputPrefix.setOnClickListener {
    val I= Intent(this,InputPrefix::class.java)
        InputPrefixResult.launch(I)
    }
   btnInputPrefix.startAnimation(AnimationUtils.loadAnimation(this,
   R.anim.move))
    btnOutputPrefix.startAnimation(AnimationUtils.loadAnimation(this,
    R.anim.rotate))
    }


}