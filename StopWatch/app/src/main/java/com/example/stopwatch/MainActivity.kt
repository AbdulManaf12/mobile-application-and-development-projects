package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var seconds = 0
    private var running = false
    private var wasRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            seconds = savedInstanceState
                .getInt("seconds")
            running = savedInstanceState
                .getBoolean("running")
            wasRunning = savedInstanceState
                .getBoolean("wasRunning")
        }
        runTimer()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState
            .putInt("seconds", seconds)
        savedInstanceState
            .putBoolean("running", running)
        savedInstanceState
            .putBoolean("wasRunning", wasRunning)
    }
    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }
    override fun onResume() {
        super.onResume()
        if (wasRunning) {
            running = true
        }
    }
    fun onClickStart(view: View?) {
        running = true
    }
    fun onClickStop(view: View?) {
        running = false
    }
    fun onClickReset(view: View?) {
        running = false
        seconds = 0
    }
    private fun runTimer() {
        val timeView = findViewById<View>(
            R.id.time_view
        ) as TextView
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = seconds % 3600 / 60
                val secs = seconds % 60
                val time: String = java.lang.String
                    .format(
                        Locale.getDefault(),
                        "%d:%02d:%02d", hours,
                        minutes, secs
                    )
                timeView.text = time
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
}