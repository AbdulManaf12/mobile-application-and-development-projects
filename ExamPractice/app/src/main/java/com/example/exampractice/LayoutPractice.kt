package com.example.exampractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class LayoutPractice : AppCompatActivity() {
    private var listOfLayout : List<String> = listOf("Linear Layout", "Constraint Layout", "Table Layout",
                                                     "Gird Layout", "Box Layout", "Relative Layout",
                                                     "Frame Layout")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_practice)

        val list = findViewById<ListView>(R.id.list)
        list.adapter = ArrayAdapter<String>(this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listOfLayout)
    }
}