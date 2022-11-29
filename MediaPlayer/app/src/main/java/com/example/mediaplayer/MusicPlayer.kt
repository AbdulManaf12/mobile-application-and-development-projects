package com.example.mediaplayer

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicPlayer : Service() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val status = intent?.getStringExtra("play")
        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.song)

        if(status == "true") {
            mediaPlayer.start()
        }else{
            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()
            }
        }

        return START_STICKY
    }
}