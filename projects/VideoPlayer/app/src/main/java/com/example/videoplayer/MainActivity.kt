package com.example.videoplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val display_screen=findViewById<VideoView>(R.id.videoView)
        val btn_load_resource=findViewById<Button>(R.id.button)
        val btn_load_internet=findViewById<Button>(R.id.button2)
        val btn_play=findViewById<Button>(R.id.button3)
        btn_load_resource.setOnClickListener {
      display_screen.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+R.raw.video2))
        }
        btn_load_internet.setOnClickListener {
            display_screen.setVideoURI(Uri.parse("http://www.drpaween.com/ohm/cs436/mv.mp4"))
        }
     btn_play.setOnClickListener { display_screen.start() }
        display_screen.setMediaController(MediaController(this))
    }
}