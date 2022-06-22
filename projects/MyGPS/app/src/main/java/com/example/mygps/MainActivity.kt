package com.example.mygps

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.OnNmeaMessageListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(),LocationListener,OnNmeaMessageListener {
    lateinit var txtview1:TextView
    lateinit var txtview2:TextView
    lateinit var gps:LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION),1234)
        }
       txtview1=findViewById(R.id.textView)
       txtview2=findViewById(R.id.textView2)
       gps=getSystemService(Context.LOCATION_SERVICE) as LocationManager
        gps.addNmeaListener(this)
    }

    override fun onResume() {
        super.onResume()
    if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION),1234)
    }else{
      gps.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000,1f,this)
    }
    }
    override fun onPause() {
        super.onPause()
        gps.removeUpdates(this)
    }
    override fun onLocationChanged(p0: Location) {
        txtview1.text="Lat:${p0.latitude}\nLong:${p0.longitude}\nAlt:${p0.altitude}\nSpeed:${p0.speed}\nClock:${p0.time}"

    }
    override fun onNmeaMessage(p0: String?, p1: Long) {
        txtview2.text=p0 + "\n"+txtview2.text
    }
}