package com.example.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn: Button = findViewById(R.id.start_btn)
        val stopBtn: Button = findViewById(R.id.stop_btn)
        val sendBtn: Button = findViewById(R.id.send_data_btn)
        val serviceInfo: TextView = findViewById(R.id.service_info)

        startBtn.setOnClickListener {
            val intent: Intent = Intent(this, MyService::class.java)
            startService(intent)
            serviceInfo.text = "Service is running"
        }

        stopBtn.setOnClickListener {
            val intent: Intent = Intent(this, MyService::class.java)
            stopService(intent)
            serviceInfo.text = "Service stopped"
        }

        sendBtn.setOnClickListener {
            val intent: Intent = Intent(this, MyService::class.java)
            intent.putExtra("EXTRA_DATA", findViewById<EditText>(R.id.data_field).text.toString())
            startService(intent)
        }
    }
}