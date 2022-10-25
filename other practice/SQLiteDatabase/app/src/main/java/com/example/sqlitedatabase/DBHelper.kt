package com.example.sqlitedatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHelper(val context: Context, val DBName: String) :
    SQLiteOpenHelper(context, DBName, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE Users(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Age INTEGER,Email TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user: User) {
        val db = writableDatabase
        var cv = ContentValues()

        cv.put("Name", user.name)
        cv.put("Age", user.age)
        cv.put("Email", user.email)
        val result = db.insert("Users", null, cv)
        db.close()

        if (result == -1.toLong()) {
            Toast.makeText(context, "Error: Unable to insert data", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_SHORT).show()
        }
    }

    fun readData() : MutableList<User> {
        val list: MutableList<User> = ArrayList()
        val db = readableDatabase
        val query = "SELECT * FROM Users"
        val result = db.rawQuery(query, null)

        if(result.moveToFirst()) {
            do {
                val name = result.getString(1) // If you don't know the index, then user result.getColumnIndex(COL_NAME)
                val age = result.getInt(2)
                val email = result.getString(3)
                val user: User = User(name, age, email)
                list.add(user)
            } while (result.moveToNext())
        }
        result.close()
        return list
    }

    fun deleteData(colID: Int) {
        val db = writableDatabase
        db.delete("Users", "ID=?", arrayOf(colID.toString()))
        db.close()
        Toast.makeText(context, "Record Deleted Successfully", Toast.LENGTH_SHORT).show()
    }

    fun updateData() {
        val list: MutableList<User> = ArrayList()
        val db = writableDatabase
        val query = "SELECT * FROM Users"
        val result = db.rawQuery(query, null)

        if(result.moveToFirst()) {
            do {
                val ageIndex = result.getColumnIndex("Age")
                val cv = ContentValues()
                cv.put("Age", result.getInt(ageIndex) + 1)
                db.update("Users", cv, "ID=? AND Age=?",
                    arrayOf(result.getInt(0).toString(), result.getInt(ageIndex).toString()))
            } while (result.moveToNext())
        }
        result.close()
    }
}