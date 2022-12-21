package com.example.mymoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.runOnUiThread
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtinput=findViewById<EditText>(R.id.editTextNumber)
        val spinner=findViewById<Spinner>(R.id.spinner)
        val txtoutput=findViewById<TextView>(R.id.textView)
        var currency_list= mutableListOf<String>()
        lateinit var rates:JSONObject
       var adapter =ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,currency_list)
       spinner.adapter=adapter
        doAsync {
            var url= URL("https://open.er-api.com/v6/latest/THB")
            var conn=url.openConnection() as HttpURLConnection
            conn.requestMethod="GET"
            conn.connect()
            var response=BufferedReader(InputStreamReader(conn.inputStream)).readLine()
            Log.v("Server_Response",response.toString())
            var server_response=JSONObject(response)
            rates=server_response.getJSONObject("rates")
            for (i in rates.keys()){
               currency_list.add(i)
            }
           runOnUiThread {adapter.notifyDataSetChanged() }
        }
   spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
       override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
       if(txtinput.text.isEmpty()==true)return
       txtoutput.text=(txtinput.text.toString().toDouble()*rates.getDouble(currency_list[p2])).toString()+ " "+currency_list[p2]
       }
       override fun onNothingSelected(p0: AdapterView<*>?) {     }
   }
    }
}