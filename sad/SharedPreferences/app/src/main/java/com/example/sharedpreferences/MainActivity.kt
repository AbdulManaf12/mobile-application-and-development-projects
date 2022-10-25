package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameField: EditText = findViewById(R.id.name_field)
        val ageField: EditText = findViewById(R.id.age_field)
        val saveBtn: Button = findViewById(R.id.save_btn)
        val loadBtn: Button = findViewById(R.id.load_btn)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        saveBtn.setOnClickListener {
            val name = nameField.text.toString()
            val age = ageField.text.toString().toInt()

            editor.apply {
                putString("name", name)
                putInt("age", age)
                apply()
            }
        }

        loadBtn.setOnClickListener {
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)

            nameField.setText(name)
            ageField.setText(age.toString())
        }
    }
}