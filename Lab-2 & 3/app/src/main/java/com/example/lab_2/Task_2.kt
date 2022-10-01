package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class Task_2 : AppCompatActivity()
{
    lateinit var img : ImageView
    lateinit var text : TextView
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        img = findViewById(R.id.imageView)
        text = findViewById(R.id.textView)
        btn = findViewById(R.id.button)
    }

    fun eat_something(view : View){
        if(btn.text == "Done"){
            finish()
        }
        img.setImageResource(R.drawable.full)
        text.text = "I'm so full"
        btn.text = "Done"
    }
}