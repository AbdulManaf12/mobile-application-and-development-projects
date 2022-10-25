package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var boxers: Array<Boxer>;
    private lateinit var listView: ListView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.listView = findViewById(R.id.listView)

        val list: ArrayList<Boxer> = ArrayList()

        list.add(Boxer("Floyd Mayweather", R.drawable.floyd))
        list.add(Boxer("Canelo Alvarez", R.drawable.canelo))
        list.add(Boxer("Maguel Cotto", R.drawable.cotto))
        list.add(Boxer("M. Ali", R.drawable.ali))
        list.add(Boxer("Lomachenko", R.drawable.loma))
        list.add(Boxer("Mike Tyson", R.drawable.tyson))

        listView.adapter = CustomArrayAdapter(this, R.layout.activity_custom_list_view, list)

        // Creating an event listener for the list view
        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Boxer: ${list[i].name}", Toast.LENGTH_LONG).show()
        }
    }
}