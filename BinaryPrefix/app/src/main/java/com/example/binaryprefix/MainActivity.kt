package com.example.binaryprefix

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.button)
        val btn2=findViewById<Button>(R.id.button2)
        val txtview=findViewById<TextView>(R.id.textView)
        val txtinput=findViewById<EditText>(R.id.editTextNumber)
        var bytevalue:Double=0.0
        val InputPrefixResult= registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                txtview.text = result.data?.getStringExtra("prefix") ?: "no data"
                bytevalue = when (result.data!!.getStringExtra("prefix")) {
                    "kB" -> txtinput.text.toString().toLong() * Math.pow(10.0, 3.0)
                    "MB" -> txtinput.text.toString().toLong() * Math.pow(10.0, 6.0)
                    "GB" -> txtinput.text.toString().toLong() * Math.pow(10.0, 9.0)
                    "TB" -> txtinput.text.toString().toLong() * Math.pow(10.0, 12.0)
                else->0.0
                        }
                //txtview.text="%10f".format(bytevalue)+" Bytes"
                txtview.text= DecimalFormat("#,###,###").format(bytevalue)+ " Bytes"
                btn2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.bounce))
            }
        }
        val TargetPrefixResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result: ActivityResult->
            if(result.resultCode== RESULT_OK){
            var ans:String= when(result.data!!.getStringExtra("prefix")){
                "KiB"-> (bytevalue/Math.pow(2.0,10.0)).toString()+" KiB"
                "MiB"-> (bytevalue/Math.pow(2.0,20.0)).toString()+" MiB"
                "GiB"-> (bytevalue/Math.pow(2.0,30.0)).toString()+" GiB"
                "TiB"-> (bytevalue/Math.pow(2.0,40.0)).toString()+" TiB"
                else->" Error"
            }
                Log.v("Testing",ans)
                val i=Intent(this,ShowResult::class.java)
                i.putExtra("result",ans)
                startActivity(i)
            }
        }

        btn.setOnClickListener(){
            val i=Intent(this,InputPrefix::class.java)
             InputPrefixResult.launch(i)
        }

        btn2.setOnClickListener(){
            val i=Intent(this,TargetPrefix::class.java)
            TargetPrefixResult.launch(i)
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }
}