package com.example.lab_1

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.core.view.isVisible

class Task_3 : AppCompatActivity() {
    var hashMap : HashMap<Int, Int>
            = HashMap<Int, Int> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task3)
        hashMap.put(R.id.hatCheck, R.id.hat)
        hashMap.put(R.id.eyebrowCheck, R.id.eyebrows)
        hashMap.put(R.id.noseCheck, R.id.nose)
        hashMap.put(R.id.moustacheCheck, R.id.moustache)
        hashMap.put(R.id.armsCheck, R.id.arms)
        hashMap.put(R.id.eyesCheck, R.id.eyes)
        hashMap.put(R.id.glassesCheck, R.id.glasses)
        hashMap.put(R.id.mouthCheck, R.id.mouth)
        hashMap.put(R.id.earsCheck, R.id.ears)
        hashMap.put(R.id.shoesCheck, R.id.shoes)
    }

    fun showPart(view: View) {
        val currentID = view.id
        val partID = hashMap.get(currentID)!!.toInt()
        val status = findViewById<ImageView>(partID).isVisible
        findViewById<ImageView>(partID).isVisible = !status
    }
}