package com.example.filingexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var output_text : TextView
    lateinit var input_text : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        output_text = findViewById(R.id.text_output)
        input_text = findViewById(R.id.text_input)
    }

    fun read(view : View){
        val dir = baseContext.filesDir
        val file = File(dir, "mydata")
        var sc = Scanner(file)
        var text : String = ""
        while (sc.hasNext()){
            text += sc.nextLine() + "\n"
        }
        sc.close()
        output_text.text = text
    }

    fun write(view: View){
        var text = input_text.text.toString()

        try{
            if (text.isEmpty()){
                throw Exception()
            }
            var outputStream = openFileOutput("mydata", Context.MODE_PRIVATE)
            outputStream.write(text.toByteArray())
            outputStream.close()
            Toast.makeText(this, "Successfully Added..!", Toast.LENGTH_LONG).show()
            input_text.text.clear()
        }
        catch (e : Exception){
            Toast.makeText(this, "invalid operation..!", Toast.LENGTH_LONG).show()
        }
    }
}