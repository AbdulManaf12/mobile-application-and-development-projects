package com.example.exampractice

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class FilingAndAdapterExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filing_and_adapter_example)
    }

    fun write(view : View){
        val filename = "myfile"
        val fileContents = "Hello world!"
            baseContext.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it.write(fileContents.toByteArray())
        }
    }

    fun read(view: View){
    }
    fun listofFiles(view: View){
        val files: Array<String> = baseContext.fileList()
        var text : String = "Files: "
        for (f in files){
            text += "\n" + f
        }
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    fun loadData(view: View) {
        val items: Array<String> = arrayOf(
            "Abdul Manaf", "Ammar Ahmed", "Naveed Ahmed",
            "Rashid Abbass", "Abdul Hafeez", "M. Afzal", "M. Ahsan", "Ghulam Mujtaba"
        )

        val myList: ListView = findViewById(R.id.friends)
        val mybtn: Button = findViewById(R.id.load_btn)

        myList.adapter =
            ArrayAdapter<String>(this, R.layout.friendslayout, R.id.itemTextView, items)
        myList.setOnItemClickListener { parent, view, position, id ->
            val friend : String = items[position]
            mybtn.text = "Manaf"
            Toast.makeText(this, friend, Toast.LENGTH_LONG).show()
        }
    }
}