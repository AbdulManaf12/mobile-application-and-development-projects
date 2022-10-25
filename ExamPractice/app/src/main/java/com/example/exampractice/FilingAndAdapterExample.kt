package com.example.exampractice

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FilingAndAdapterExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filing_and_adapter_example)
    }

    fun write(view : View){
        val filename = "myfile"
        val fileContents = "Hello world!"
            baseContext.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it.write(fileContents.toByteArray())
        }
    }

    fun read(view: View){
//        var str : String = ""
//        val filename = "myfile"
//        val bufferedReader = baseContext.openFileInput(filename).bufferedReader()
//
//        val sb = StringBuilder()
//        var line: String?
//        while (bufferedReader.readLine().also { line = it } != null) {
//            sb.append(line)
//        }
//        bufferedReader.close()
//            .useLines {
//                lines ->
//            lines.fold("") { some, text ->
//                "$some\n$text"
//            }
//        }
    }
    fun listofFiles(view: View){
        val files: Array<String> = baseContext.fileList()
        var text : String = "Files: "
        for (f in files){
            text += "\n" + f
        }
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

}