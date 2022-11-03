package com.example.madlibs

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList


class InputTakerActivity : AppCompatActivity() {

    lateinit var story : String
    lateinit var wordTokens : ArrayList<Tokens>
    private var input_traker = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_taker)
        wordTokens = ArrayList()
        loadStory()
    }

    fun loadStory() {
        val stories : Array<Int> = arrayOf(R.raw.madlib0, R.raw.madlib1, R.raw.madlib2,
                                           R.raw.madlib3, R.raw.madlib4)
        val randomStory = stories[Random().nextInt(stories.size)]
        val inputStream: InputStream = resources.openRawResource(randomStory)
        val reader = BufferedReader(InputStreamReader(inputStream))
        var storyText : String = ""
        try {
            var line: String? = null
            line = reader.readLine()
            while (line != null) {
                storyText += line + "\n"
                line = reader.readLine()
            }
        } finally {
            reader.close()
        }
        story = storyText
        parseWordTokens(storyText)
    }

    private fun parseWordTokens(storyText : String){
        val pattern : Regex = Regex("<(\\w*)(-|')*(\\w*)(-|')*(\\w*)>")
        var results = pattern.findAll(storyText)
        for (i in results){
            var tokenType = (i.value.replace("<","")).replace(">", "")
            wordTokens.add(Tokens(tokenType, ""))
        }
        setTokens()
    }
    fun setTokens(){
        findViewById<TextView>(R.id.words_counter).text = "${wordTokens.size-input_traker} word(s) left"
        findViewById<EditText>(R.id.input).hint = wordTokens[input_traker].key
        findViewById<TextView>(R.id.type).text = "please type a/an ${wordTokens[input_traker].key}"
    }
    class Tokens(key : String, value : String){
        var key = key
        var value = value
    }
    fun submitInput(view : View){
        var input = findViewById<EditText>(R.id.input).text.toString()
        findViewById<EditText>(R.id.input).text.clear()
        wordTokens[input_traker].value = input
        input_traker++
        if (wordTokens.size == input_traker){
            showResultOfStory()
        }else {
            setTokens()
        }
    }
    fun showResultOfStory(){
        val pattern : Regex = Regex("<(\\w*)(-|')*(\\w*)(-|')*(\\w*)>")
        var i = 0
        while (i != wordTokens.size){
            story = story.replaceFirst(pattern, wordTokens[i++].value)
        }
        val intent = Intent(this, ResultStory::class.java)
        intent.putExtra("story", story)
        startActivity(intent)
    }
}