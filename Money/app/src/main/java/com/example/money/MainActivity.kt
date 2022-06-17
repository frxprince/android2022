package com.example.money

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import android.view.View
import android.widget.*
import org.jetbrains.anko.doAsync
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner=findViewById<Spinner>(R.id.spinner)
        val txtinput=findViewById<EditText>(R.id.editTextNumber)
        val txtoutput=findViewById<TextView>(R.id.textView)
        lateinit var rates:JSONObject
        var currency_list= mutableListOf<String>()
        val adapter=ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,currency_list)
        spinner.adapter=adapter
        spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (txtinput.text.isEmpty())return
                Log.v("test",rates.getDouble(currency_list[p2]).toString())
                txtoutput.text=(txtinput.text.toString().toDouble()
                *  rates.getDouble(currency_list[p2])).toString()+" "+currency_list[p2]

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        doAsync {
            var url = URL("https://open.er-api.com/v6/latest/THB")
            var conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.connect()
            var response = BufferedReader(InputStreamReader(conn.inputStream)).readLine()
            Log.v("response", response.toString())
            var server_response= JSONObject(response)
            rates=server_response.getJSONObject("rates")

            Log.v("test",rates.getString("USD"))
            for (i in rates.keys()){
                Log.v("test","$i -> ${rates.getDouble(i)}")
                currency_list.add(i)
            }
            adapter.notifyDataSetChanged()
        }


    }
}