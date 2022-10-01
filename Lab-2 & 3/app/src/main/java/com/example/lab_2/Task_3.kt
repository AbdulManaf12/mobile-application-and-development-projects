package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class Task_3 : AppCompatActivity()
{
    lateinit var result_text : TextView
    lateinit var num_text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task3)

        result_text = findViewById(R.id.order_summary)
        num_text = findViewById(R.id.quantity)
    }

    fun inc(view: View){
        num_text.text = (num_text.text.toString().toInt() + 1).toString()
    }
    fun dec(view: View){
        if (num_text.text.toString().toInt() > 0){
            num_text.text = (num_text.text.toString().toInt() - 1).toString()
        }
    }
    fun order(view : View){
        var ammount : Float = 0f
        var result : String = "Add whipped cream?"

        if(findViewById<CheckBox>(R.id.cream).isChecked){
            result += " yes\n"
            ammount += 0.50f
        }else{
            result += " no\n"
        }

        result += "Add Chocolate?"
        if(findViewById<CheckBox>(R.id.chocolate).isChecked){
            result += " yes\n"
            ammount += 1.00f
        }else{
            result += " no\n"
        }

        result += "Quantity: ${num_text.text}\n\n"
        ammount += (num_text.text.toString().toInt() * 4.00f)
        result += "Price: $${ammount}\n THANK YOU!"
        result_text.text = result
    }
}