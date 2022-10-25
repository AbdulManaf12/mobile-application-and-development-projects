package com.example.exampractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

class WidgetsPractice : AppCompatActivity() {

    private lateinit var btn : Button
    private lateinit var img : ImageView
    private lateinit var switch : Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widgets_practice)
        initComponents()

        val title : TextView = findViewById(R.id.title)
        title.text = intent.getStringExtra("Title")
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

    fun clickMe(view: View){
        val intent : Intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Message", "Hello Manaf How are you!")
        setResult(RESULT_OK, intent)
        finish()
    }
}