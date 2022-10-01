package com.example.acplmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun login(view : View){
        val username : EditText = findViewById(R.id.username)
        val password : EditText = findViewById(R.id.password)

        if (validate(username.text.toString(), password.text.toString())){
            username.text.clear()
            password.text.clear()

            Toast.makeText(this, "Successfully Login", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainPage::class.java))
        }
        else{
            Toast.makeText(this, "Invalid username or email", Toast.LENGTH_SHORT).show()
        }

    }
    private fun validate(username : String, password : String) : Boolean {
        return (username == "admin" && password == "admin")
    }
}