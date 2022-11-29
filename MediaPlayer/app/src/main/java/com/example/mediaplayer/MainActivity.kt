package com.example.mediaplayer

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn: Button = findViewById(R.id.start_btn)
        val stopBtn: Button = findViewById(R.id.stop_btn)

        startBtn.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("play", "true")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                applicationContext.startForegroundService(intent)
            }else{
                Toast.makeText(this, "nope", Toast.LENGTH_LONG).show()
            }
        }

        stopBtn.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("play", "false")
            stopService(intent)
        }
    }
}