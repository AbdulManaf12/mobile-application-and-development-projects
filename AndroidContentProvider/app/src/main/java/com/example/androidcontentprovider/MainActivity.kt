package com.example.androidcontentprovider

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array = ArrayList<String>()
        val list = findViewById<ListView>(R.id.list)

        val cursor: Cursor? = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME),
            null, null, null
        )

        cursor?.moveToFirst()
        do{
            cursor?.getString(0)?.let { array.add(it) }
        }while (cursor!!.moveToNext())

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        list.adapter = adapter

    }
}