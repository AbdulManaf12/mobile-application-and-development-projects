package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MediaPlayer : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

//        mediaPlayer = MediaPlayer.create(this, R.raw.A)

    }


}