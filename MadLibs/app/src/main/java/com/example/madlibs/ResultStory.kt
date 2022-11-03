package com.example.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ResultStory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_story)
        val storyText = intent.getStringExtra("story")
        findViewById<TextView>(R.id.story_output).text = storyText
    }
    fun makeAnotherStory(view : View){
        startActivity(Intent(this, InputTakerActivity::class.java))
    }
}