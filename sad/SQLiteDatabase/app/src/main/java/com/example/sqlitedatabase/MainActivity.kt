package com.example.sqlitedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameField: EditText = findViewById(R.id.name_field)
        val ageField: EditText = findViewById(R.id.age_field)
        val emailField: EditText = findViewById(R.id.email_field)
        val colIDField: EditText = findViewById(R.id.id_field)
        val recordsField: TextView = findViewById(R.id.records_field)

        val btnInsert: Button = findViewById(R.id.btn_save)
        val btnRead: Button = findViewById(R.id.btn_load)
        val btnDelete: Button = findViewById(R.id.btn_delete)
        val btnUpdate: Button = findViewById(R.id.btn_update)

        val dbHelper: DBHelper = DBHelper(this, "MyDB")

        btnInsert.setOnClickListener {
            val name: String = nameField.text.toString()
            val age: String = ageField.text.toString()
            val email: String = emailField.text.toString()

            if (name.isNotEmpty() && age.isNotEmpty() && email.isNotEmpty()) {
                val user: User = User(name, age.toInt(), email)
                dbHelper.insertData(user)
            } else {
                Toast.makeText(this, "Please fill the fields", Toast.LENGTH_LONG).show()
            }
        }

        btnRead.setOnClickListener {
            val data: MutableList<User> = dbHelper.readData()
            var toShow: String = ""

            for (user in data) {
                toShow += "Name: ${user.name}, Age: ${user.age}, Email: ${user.email}\n"
            }
            recordsField.text = toShow
        }

        btnDelete.setOnClickListener {
            val colID = colIDField.text.toString()
            if (colID.isNotEmpty())
                dbHelper.deleteData(colID.toInt())
        }

        btnUpdate.setOnClickListener {
            dbHelper.updateData()
            btnRead.performClick()
        }
    }
}