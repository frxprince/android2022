package com.example.audioplayer

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.core.app.ActivityCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_load_resource=findViewById<Button>(R.id.button)
        val btn_load_sdcard=findViewById<Button>(R.id.button2)
        val btn_load_streaming=findViewById<Button>(R.id.button3)
        val btn_play=findViewById<Button>(R.id.button4)
        val btn_pause=findViewById<Button>(R.id.button5)
        val btn_stop=findViewById<Button>(R.id.button6)
        var Mp=MediaPlayer()

        btn_load_resource.setOnClickListener {
            Mp=MediaPlayer.create(this,R.raw.greeting)
        }
        btn_play.setOnClickListener { Mp.start()}
        btn_pause.setOnClickListener { Mp.pause() }
        btn_stop.setOnClickListener { Mp.stop() }
if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=
        PackageManager.PERMISSION_GRANTED){
   ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
   ,1234)
if(ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!=PackageManager.PERMISSION_GRANTED)
{
 ActivityCompat.requestPermissions(this, arrayOf( Manifest.permission.INTERNET),1234)
}
}
btn_load_sdcard.setOnClickListener {
    Mp= MediaPlayer()
    Mp.setDataSource(Environment.getExternalStorageDirectory().path+"/song.mp3")
    Mp.prepare()
}
        btn_load_streaming.setOnClickListener {
            Mp.setDataSource(this,
            Uri.parse("http://62.171.152.216:8000/stream/502903/"))
             Mp.prepare()
        }
    }
}