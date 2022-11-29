package com.example.alarmmanagertask

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun setAlarm(view : View){
        var time = findViewById<EditText>(R.id.editTextTime).text.toString()
        var nums = time.split(":")
        if(nums.size == 3) {
            val hourSeconds = TimeUnit.HOURS.toMillis(Integer.parseInt(nums[0]).toLong())
            val minutesSeconds = TimeUnit.MINUTES.toMillis(Integer.parseInt(nums[1]).toLong())
            val Seconds = TimeUnit.SECONDS.toMillis(Integer.parseInt(nums[2]).toLong())

            val period = System.currentTimeMillis() + hourSeconds + minutesSeconds + Seconds

            val intent: Intent = Intent()
            val alarmManager: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            val pIntent: PendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
            alarmManager.set(AlarmManager.RTC, period, pIntent)
            Toast.makeText(this, "Wakeup", Toast.LENGTH_LONG).show()

            val notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val r = RingtoneManager.getRingtone(applicationContext, notification)
            r.play()
        }else{
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show()
        }
    }
}