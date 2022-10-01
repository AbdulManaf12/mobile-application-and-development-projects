package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class Task_5 : AppCompatActivity()
{
    private lateinit var list_of_words : List<String>
        private lateinit var selectedWord : String
    private var life : Int = 3
    private lateinit var word_display : TextView
    private lateinit var input_field : EditText
    private lateinit var number_of_guesses : TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task5)

        list_of_words = listOf<String>(
            "apples","mango", "banana", "monday", "friday", "winter", "watermelon", "elephant",
            "tomato", "human", "distributive", "umbrella", "hungry", "yellow", "australia",
            "orange", "laptop", "technology", "school", "university","mother", "father")

        word_display = findViewById(R.id.word)
        input_field = findViewById(R.id.guess_input)
        number_of_guesses = findViewById(R.id.times)
        setRandomWord()
    }

    fun setRandomWord(){
        life = 3
        var resultString : String = ""
        selectedWord = list_of_words[Random.nextInt(list_of_words.size)]
        for(i in 0..(selectedWord.length-1)){
            resultString += "?"
        }
        var times = (resultString.length * 0.4).toInt()
        while (times > 0){
            var randomIndex = Random.nextInt(resultString.length-1)
            if(resultString[randomIndex] == '?') {
                var stringArray = resultString.toCharArray()
                stringArray[randomIndex] = selectedWord[randomIndex]
                resultString = String(stringArray)
                times--
            }
        }
        word_display.text = resultString
    }
    fun GuessBtn(view: View){
        if(input_field.text.length > 0 && life > 0) {
            var char = input_field.text[0]
            if (char.isLetter()) {
                var flag : Boolean = false
                var resultArray = selectedWord.toCharArray()
                for(i in 0..(resultArray.size-1)){
                    if(resultArray[i] == char){
                        var resultString = word_display.text.toString().toCharArray()
                        resultString[i] = selectedWord[i]
                        word_display.text = String(resultString)
                        flag = true
                    }
                }
                if(!flag){
                    life--
                    findViewById<ImageView>(R.id.logo)
                        .setImageResource(when(life){
                        2 -> R.drawable.guess_2
                        1 -> R.drawable.guess_3
                        else -> R.drawable.guess_4
                        })
                    number_of_guesses.text = "You have guessed: aest(${life} guesses left)"
                    if (life == 0){
                        findViewById<TextView>(R.id.result).text = "You Lost ... !"
                        Toast.makeText(this, "You Lost ...!", Toast.LENGTH_SHORT)
                    }
                }
                else{
                    flag = true
                    for(i in word_display.text.toString()){
                        if(i == '?'){
                            flag = false
                        }
                    }
                    if(flag){
                        findViewById<TextView>(R.id.result).text = "You Won ... !"
                    }
                }
            } else {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT)
            }
            input_field.text.clear()
        }else{
            Toast.makeText(this, "Empty Input", Toast.LENGTH_SHORT)
        }
    }
    fun NewBtn(view : View){
        setRandomWord()
        life = 3
        findViewById<TextView>(R.id.result).text = "?"
        number_of_guesses.text = "You have guessed: aest(${life} guesses left)"
    }
}