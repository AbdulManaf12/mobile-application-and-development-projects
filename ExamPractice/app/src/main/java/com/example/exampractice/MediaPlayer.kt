package com.example.exampractice

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MediaPlayer : AppCompatActivity() {
    private lateinit var audio : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)
        audio = MediaPlayer.create(applicationContext, R.raw.love)
    }
    fun playSong(view : View){
        if (!audio.isPlaying) {
            audio.start()
        }
    }
    fun pauseSong(view : View){
        if (audio.isPlaying){
            audio.pause()
        }
    }

    override fun onStop() {
        super.onStop()
        if (audio.isPlaying){
            audio.stop()
        }
    }
}