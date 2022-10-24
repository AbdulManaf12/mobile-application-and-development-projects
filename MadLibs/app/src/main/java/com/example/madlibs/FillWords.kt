package com.example.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_main)
    }

    fun start(view: View) {
        val btn: Button = view as Button
        val intent: Intent = Intent(this, FillWords::class.java)
        startActivity (intent)
    }
}
