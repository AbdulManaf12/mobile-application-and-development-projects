package com.example.practice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import org.w3c.dom.Text
import java.io.OutputStreamWriter
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    data class User(val name: String, val age: Int) : Serializable
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
//        You can put the serializable object as follows:
//        val user: User = User("Ammar", 23)
//        outState.putSerializable("userObj", user)
        outState.putInt("counter", this.counter)
    }

    override fun onResume() {
        super.onResume()
        this.counter += 2
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

//        Read the serializable object as follows
//        this.user = savedInstanceState.getSerializable("userObj") as User
        val readVal = savedInstanceState.getInt("counter").toString()
        Log.d("print", readVal)
        findViewById<TextView>(R.id.textView).text = readVal
    }
}