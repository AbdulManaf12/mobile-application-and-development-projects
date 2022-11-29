package com.example.stopwatchtoogle

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Matrix;


class MainActivity : AppCompatActivity() {
    private var wasRunning = false
    private var live = 20f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            wasRunning = savedInstanceState
                .getBoolean("wasRunning")
        }
        runTimer()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putBoolean("wasRunning", wasRunning)
    }
    fun onClickStart(view: View?) {
        wasRunning = !wasRunning
    }
    private fun runTimer() {
        val image = findViewById<View>(R.id.imageView) as ImageView
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                if (wasRunning) {
                    roateImage(image)
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
    private fun roateImage(imageView: ImageView) {
        val matrix = Matrix()
        imageView.scaleType = ImageView.ScaleType.MATRIX //required
        matrix.postRotate(
            live,
            (imageView.drawable.bounds.width() / 2).toFloat(),
            (imageView.drawable.bounds.height() / 2).toFloat()
        )
        imageView.imageMatrix = matrix
        live += 20
        if (live >= 360)
            live = 0f
    }
}
