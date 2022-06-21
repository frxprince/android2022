package com.example.binaryprefix

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        setContentView(R.layout.activity_welcome)
        val btn=findViewById<ImageButton>(R.id.imageButton)
      btn.setOnClickListener {
          val I =Intent(this,MainActivity::class.java)
          startActivity(I)
        }

        /*val I =Intent(this,MainActivity::class.java)
        btn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {

                startActivity(I)
            }
        }) */

    }
}