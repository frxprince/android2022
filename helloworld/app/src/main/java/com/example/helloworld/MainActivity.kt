package com.example.helloworld

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("My Helloworld APP","Program started!")
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.v("My Helloworld APP","Program Create!")
    }

    override fun onResume() {
        super.onResume()
        Log.v("My Helloworld APP","Program Resume!")
    }

    override fun onPause() {
        super.onPause()
        Log.v("My Helloworld APP","Program Pause!")
    }
}