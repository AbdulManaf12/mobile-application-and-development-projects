package com.example.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomArrayAdapter(val c: Context, val resource: Int, val boxers: List<Boxer>):
    ArrayAdapter<Boxer> (c, resource, boxers) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(c)
        val view: View = layoutInflater.inflate(resource, null)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        val nameText: TextView = view.findViewById(R.id.name)

        val boxer: Boxer = boxers[position]
        imageView.setImageResource(boxer.img)
        nameText.text = boxer.name

        return view
    }
}