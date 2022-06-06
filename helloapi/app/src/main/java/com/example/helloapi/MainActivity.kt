package com.example.helloapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jetbrains.anko.doAsync
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
doAsync {
    var url = URL("https://open.er-api.com/v6/latest/THB")
    var conn = url.openConnection() as HttpURLConnection
    conn.requestMethod = "GET"
    conn.connect()
    var response = BufferedReader(InputStreamReader(conn.inputStream)).readLine()
    Log.v("response", response.toString())
    var server_response=JSONObject(response)
    var rates=server_response.getJSONObject("rates")

    Log.v("test",rates.getString("USD"))
    for (i in rates.keys()){
        Log.v("test","$i -> ${rates.getDouble(i)}")
    }
}
    }
}