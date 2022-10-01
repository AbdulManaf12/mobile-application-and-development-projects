package com.example.lab_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*

class Task_1 : AppCompatActivity() {
    private var numToGuess : Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        val random = Random()
        numToGuess = random.nextInt(1000)
    }
    fun Validate(view: View){
        val inputField = findViewById<EditText>(R.id.input_number)
        val textLabel = findViewById<TextView>(R.id.output_text)
        try{
            val number = inputField.text.toString().toInt()

            if (number > numToGuess){
                textLabel.text = "Your Guess is Too High"
            }else if (number < numToGuess){
                textLabel.text = "Your Guess is Too Low"
            }
            else{
                textLabel.text = "Hoorah!! ... You guessed it correctly"
            }
        }catch (e : Exception){
            textLabel.text = "Invalid input"
        }
    }

}