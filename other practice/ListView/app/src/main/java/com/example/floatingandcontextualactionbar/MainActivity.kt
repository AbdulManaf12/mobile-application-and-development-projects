package com.example.floatingandcontextualactionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countries = arrayOf("USA", "UK", "Estonia", "Romania", "Italy", "Brazil", "Mexico", "France", "Spain")
        val listView : ListView = findViewById(R.id.myList)

        val adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Item Clicked: ${countries[i]}", Toast.LENGTH_SHORT).show()
        }
    }
}