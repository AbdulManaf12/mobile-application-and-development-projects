package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Task_4 : AppCompatActivity()
{
    private var operation : Char = '\u0000'
    private var num1 : Int = 0
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4)

        result = findViewById(R.id.result)
        result.isEnabled = false
    }
    fun Number(view: View){
        result.text = result.text.toString() + (view as Button).text.toString()
    }
    fun operation(view : View){
        val btn : Button = view as Button

        num1 = result.text.toString().toInt()
        result.text = ""
        operation = if(btn.text.toString() == "+"){
            '+'
        } else if(btn.text.toString() == "-"){
            '-'
        } else if(btn.text.toString() == "/"){
            '/'
        } else if(btn.text.toString() == "%"){
            '%'
        } else{
            '*'
        }
    }

    fun clear_text(view: View){
        result.text = ""
        num1 = 0
        operation = '\u0000'
    }

    fun calculate(view: View){
        if(operation != '\u0000' && num1 != 0 && result.text.toString().isNotEmpty()) {
            var num2: Int = result.text.toString().toInt()
            if (num2 == 0 && operation == '/') {
                num2 = 0
            } else {
                num2 = when (operation) {
                    '+' -> {
                        (num1 + num2)
                    }
                    '-' -> {
                        (num1 - num2)
                    }
                    '/' -> {
                        (num1 / num2)
                    }
                    '*' -> {
                        (num1 * num2)
                    }
                    '%' -> {
                        (num1 % num2)
                    }
                    else -> {
                        num2
                    }
                }
            }
            result.text = num2.toString()
            num1 = 0
            operation = '\u0000'
        }
    }
}