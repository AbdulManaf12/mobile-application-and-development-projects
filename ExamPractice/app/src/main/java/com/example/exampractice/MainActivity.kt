package com.example.exampractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoWidgets(view : View){
        startActivity(Intent(this, WidgetsPractice::class.java))
    }

    fun gotoLayouts(view: View){
        startActivity(Intent(this, LayoutPractice::class.java))
    }

    fun gotoActivityLifeCycle(view: View){
        startActivity(Intent(this, ActivityLifeCycleExample::class.java))
    }
}