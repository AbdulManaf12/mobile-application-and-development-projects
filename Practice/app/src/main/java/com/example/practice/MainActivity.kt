package com.example.practice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    //    lateinit var menu: Menu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        #1. Widgets
        startActivity(Intent(this, Widgets::class.java))
    }
}

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.mainmenu, menu)
//        if (menu != null) {
//            this.menu = menu
//        }
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.play && item.title == "Play") {
//            item.setIcon(R.drawable.pause)
//            item.title = "Pause"
//        }else{
//            item.setIcon(R.drawable.play)
//            item.title = "Play"
//        }
//        return true
//    }

}