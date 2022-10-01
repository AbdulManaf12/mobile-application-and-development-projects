package com.example.lab_4_activity_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img : ImageView = findViewById(R.id.image)
        registerForContextMenu(img)
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menuInflater.inflate(R.menu.floatingmenubar, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var str : String = when(item.itemId){
            R.id.download -> ""
            R.id.newtab -> ""
            R.id.search -> ""
            R.id.share -> ""
            else -> ""
        }
        return true
    }
    fun GotoNext(view: View){
        startActivity(Intent(this, MainActivity2::class.java))
    }
}