package com.example.exampractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch

class WidgetsPractice : AppCompatActivity() {

    private lateinit var btn : Button
    private lateinit var img : ImageView
    private lateinit var switch : Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widgets_practice)
        initComponents()
    }

    private fun initComponents(){
        btn = findViewById(R.id.button)
        img = findViewById(R.id.img)
        img.setImageResource(resources.getIdentifier("phone", "drawable", packageName))
        switch = findViewById(R.id.swtch)
//        btn.text = resources.getResourceEntryName(R.drawable.phone)
//        btn.text = resources.getResourceName(R.drawable.phone)

        if (switch.isChecked){
            println("yes checked ... !")
        }
    }
}