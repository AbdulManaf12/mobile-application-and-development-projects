package com.example.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.text).text = "Hello"
    }
    fun setAlarm(view : View){
        val intent : Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val alarmManager : AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val pIntent : PendingIntent = PendingIntent.getActivity(this, 0,  intent, PendingIntent.FLAG_IMMUTABLE)
        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + (5 * 1000), pIntent)
        Toast.makeText(this, "Wakeup", Toast.LENGTH_LONG).show()

        
    }
}