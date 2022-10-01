package com.example.lab_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openTask_1(view : View){
        startActivity(Intent(this@MainActivity,Task_1::class.java))
    }

    fun openTask_2(view : View){
        startActivity(Intent(this@MainActivity,Task_2::class.java))
    }

    fun openTask_3(view : View){
        startActivity(Intent(this@MainActivity,Task_3::class.java))
    }
}