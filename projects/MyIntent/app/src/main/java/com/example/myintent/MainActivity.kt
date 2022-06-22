package com.example.myintent

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.*
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import org.jetbrains.annotations.Contract

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_www=findViewById<Button>(R.id.button)
        val btn_alarm=findViewById<Button>(R.id.button2)
        val btn_map=findViewById<Button>(R.id.button3)
        val btn_contact=findViewById<Button>(R.id.button4)
        val btn_camera=findViewById<Button>(R.id.button5)
        val imageview=findViewById<ImageView>(R.id.imageView)
    if(ActivityCompat.checkSelfPermission(this,"com.android.alarm.permission.SET_ALARM")!=
        PackageManager.PERMISSION_GRANTED){
     ActivityCompat.requestPermissions(this, arrayOf("com.android.alarm.permission.SET_ALARM"),1234)
    }
    if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS)!=PackageManager.PERMISSION_GRANTED){
    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS),1234)
    }
    btn_www.setOnClickListener {
 val I= Intent(Intent.ACTION_VIEW, Uri.parse("http://www.npru.ac.th"))
 //  if(I.resolveActivity(packageManager)!=null)
 //  {
      startActivity(I)
 //   }else{
 //     btn_www.isEnabled=false
  // }
    }
     btn_alarm.setOnClickListener {
    val I=Intent(AlarmClock.ACTION_SET_TIMER).apply {
    putExtra(AlarmClock.EXTRA_MESSAGE,"Time 's up")
    putExtra(AlarmClock.EXTRA_LENGTH,5)
   // putExtra(AlarmClock.EXTRA_SKIP_UI,true)

}
       startActivity(I)
     }

     btn_map.setOnClickListener {
         val I=Intent(Intent.ACTION_VIEW,Uri.parse("geo:13.7552743,100.4926436"))
         startActivity(I)
     }

    btn_contact.setOnClickListener {
        val I=Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI)
       startActivityForResult(I,1111)
    }
     var image:Bitmap?=null
     val cameraResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
         result:ActivityResult->
         if (result.resultCode==Activity.RESULT_OK){
          if(image!=null)image?.recycle()
          image=result.data!!.extras!!.getParcelable<Bitmap>("data")
          var canvas=Canvas()
          var image2=image!!.copy(Bitmap.Config.ARGB_8888, true)
          canvas.setBitmap(image2)
          var paint= Paint()
             paint.setColor(Color.RED)
             paint.textSize=20f
             paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_OVER))
             canvas.drawBitmap(image2!!,0f,0f,paint)
             canvas.drawText("NPRU",1f,30f,paint)
          imageview.setImageBitmap(image2)
         }
     }
    btn_camera.setOnClickListener {
        val I=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraResult.launch(I)
    }

    imageview.setOnClickListener{
    var package_list=packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
      for(item in package_list){
          Log.v("Installed"," ${item.packageName} | ${item.className}  ")
      }
    }

    }

    @SuppressLint("Range")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
      /*
        if (resultCode==Activity.RESULT_OK){
            var projection=arrayOf(ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER,ContactsContract.Contacts._ID)
            var uri=data!!.data
            var cursor=managedQuery(uri,projection,null,null,null)
            cursor.moveToFirst()
            var name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
            var id=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
            Log.v("phonebook",name)
            var cursor2=contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+id,null,null)
            cursor2!!.moveToFirst()
            var phone=cursor2.getString((cursor2.getColumnIndex("data1")))
            Log.v("phonebook","Name:$name , Phone:$phone")
        }
        */

    }
}