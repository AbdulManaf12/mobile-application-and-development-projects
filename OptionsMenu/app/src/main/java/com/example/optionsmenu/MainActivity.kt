package com.example.optionsmenu

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer : MediaPlayer
    lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer()

        textToSpeech = TextToSpeech(applicationContext) {
                status -> if (status != TextToSpeech.ERROR) {
                textToSpeech.language = Locale.UK
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menubar, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.play -> {
                if (item.title == "Play"){
                    item.title = "Pause"
                    item.setIcon(R.drawable.pause)
                    playMusic()
                }
                else{
                    item.title = "Play"
                    item.setIcon(R.drawable.play)
                    stopMusic()
                }
                return true
            }
            R.id.speak -> {
                item.setIcon(R.drawable.speaking)
                speakText()
                item.setIcon(R.drawable.speak)
                return true
            }
            else ->{
                return false
            }
        }
    }
    fun playMusic(){
        Toast.makeText(this, "Wait a moment please loading..", Toast.LENGTH_SHORT).show()
        val randomNumber : Int = (1..15).random()
        val audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-${randomNumber}.mp3"
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer.setDataSource(audioUrl)
            mediaPlayer.prepare()
            mediaPlayer.start()
        } catch (e: IOException) {
            Toast.makeText(this, "Make sure you're connected with internet", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this, "Audio started playing..", Toast.LENGTH_SHORT).show()
    }
    private fun stopMusic(){
        if(isMusicActivated()) {
            mediaPlayer.stop()
        }
    }
    private fun isMusicActivated() : Boolean{
        return mediaPlayer.isPlaying
    }
    private fun speakText(){
        val input : EditText = findViewById(R.id.text)
        if (input.text.isNotEmpty()) {
            if (isMusicActivated()) {
                stopMusic()
                val toSpeak: String = input.text.toString()
                Toast.makeText(applicationContext, toSpeak, Toast.LENGTH_SHORT).show()
                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
                playMusic()
            } else {
                val toSpeak: String = input.text.toString()
                Toast.makeText(applicationContext, toSpeak, Toast.LENGTH_SHORT).show()
                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
            }
            input.text.clear()
        }else{
            Toast.makeText(this, "Empty input", Toast.LENGTH_SHORT).show()
        }
    }
}