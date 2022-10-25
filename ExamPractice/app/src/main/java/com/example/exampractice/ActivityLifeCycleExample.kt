package com.example.exampractice

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView

class ActivityLifeCycleExample : AppCompatActivity()
{
    private lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_example)

        text = findViewById(R.id.activity_steps)
        text.text = text.text.toString() + "\nonCreate called ....!"
        println("\nonCreate called ....!")
    }

    override fun onStart() {
        super.onStart()

        val preferences : SharedPreferences = getSharedPreferences("Manaf.txt", MODE_PRIVATE)
        text.text = preferences.getString("states", "")

        text.text = text.text.toString() + "\nonStart called ....!"
        println("\nonStart called ....!")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        text.text = savedInstanceState.getString("states")
    }

    override fun onResume() {
        super.onResume()
        text.text = text.text.toString() + "\nonResume called ....!"
        println("\nonResume called ....!")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
//        outState.putString("states", text.text.toString())
    }

    override fun onPause() {
        super.onPause()
        text.text = text.text.toString() + "\nonPause called ....!"
        println("\nonPause called ....!")
    }

    override fun onRestart() {
        super.onRestart()
        text.text = text.text.toString() + "\nonRestart called ....!"
        println("\nonRestart called ....!")
    }

    override fun onStop() {
        super.onStop()
        text.text = text.text.toString() + "\nonStop called ....!"
        println("\nonStop called ....!")
    }

    override fun onDestroy() {
        super.onDestroy()
        val prefs : SharedPreferences = getSharedPreferences("Manaf.txt", MODE_PRIVATE)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putString("states", text.text.toString())
        editor.apply()

        text.text = text.text.toString() + "\nonDestory called ....!"
        println("\nonDestory called ....!")
    }

    fun goBack(view: View){
        text.text = text.text.toString() + "\nFinish called ....!"
        println("\nFinish called ....!")
        finish()
    }
}
