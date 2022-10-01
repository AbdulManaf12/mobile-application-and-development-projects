package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Task_1 : AppCompatActivity()
{
    lateinit var textarea : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)
        textarea = findViewById(R.id.result)

        textarea.text = textarea.text.toString() + "\n onCreate called ..."
    }

    override fun onStart() {
        super.onStart()
        textarea.text = textarea.text.toString() + "\n onStart called ..."
    }

    override fun onResume() {
        super.onResume()
        textarea.text = textarea.text.toString() + "\n onResume called ..."
    }

    override fun onPause() {
        super.onPause()
        textarea.text = textarea.text.toString() + "\n onPause called ..."
    }

    override fun onStop() {
        super.onStop()
        textarea.text = textarea.text.toString() + "\n onStop called ..."
    }

    override fun onRestart() {
        super.onRestart()
        textarea.text = textarea.text.toString() + "\n onRestart called ..."
    }

    override fun onDestroy() {
        super.onDestroy()
        textarea.text = textarea.text.toString() + "\n onDestroy called ..."
    }

}