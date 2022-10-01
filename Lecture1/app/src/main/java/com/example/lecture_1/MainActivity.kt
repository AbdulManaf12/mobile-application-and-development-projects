package com.example.lecture_1

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Running State", "The application is running")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Running Start", "The application is starting")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Running Pause", "The application is paused")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Running Resume", "The application is resume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Running Stop", "The application is stop")
    }

    fun open_camera(view : View){
        val url = "http://www.google.com"
        val i = Intent(ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
}