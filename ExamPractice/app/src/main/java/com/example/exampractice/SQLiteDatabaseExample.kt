package com.example.exampractice

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.util.*

class SQLiteDatabaseExample : AppCompatActivity() {

    private lateinit var database : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_database_example)
        database = openOrCreateDatabase("Manaf", MODE_PRIVATE, null)
//        createTable()
//        insertValues(1, "Abdul Manaf", "03003141736")
//        showData()
//        importDatabase()
    }

    private fun createTable() {
        if (database.isOpen){
            val createTable : String = "CREATE TABLE Student(id INTEGER, name TEXT, contact TEXT);"
            database.execSQL(createTable)
            Toast.makeText(this, "Successfully created Table ... !", Toast.LENGTH_LONG).show()
        }
    }

    fun insertValues(id : Int, name : String, contact : String){
        if (database.isOpen){
            val insertValue : String = "INSERT INTO Student values(${id}, '${name}', '${contact}');"
            database.execSQL(insertValue)
            Toast.makeText(this, "Successfully Values inserted ... !", Toast.LENGTH_LONG).show()
        }
    }
    private fun showData(){
        val showCommand : String = "SELECT * FROM Student"
        val cr = database.rawQuery(showCommand, null)
        if (cr.moveToFirst()) {
            do
            {
                val id = cr.getInt(0)
                val name = cr.getString(1)
                Toast.makeText(this, "ID: ${id} : Name: ${name}", Toast.LENGTH_LONG).show()
            }while (cr.moveToNext())
            cr.close()
        }else{
            Toast.makeText(this, "Empty Database", Toast.LENGTH_LONG).show()
        }
    }
    private fun importDatabase(){
        val scan : Scanner = Scanner(resources.openRawResource(R.raw.Student))
        var query : String = "";
        while (scan.hasNextLine()) {
            query += scan.nextLine() + "\n";
            if (query.trim().endsWith(";")) {
                database.execSQL(query);
                query = "";
            }
        }
    }
}