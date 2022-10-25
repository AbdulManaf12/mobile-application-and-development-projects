package com.example.usingexternalstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.PrintStream
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        this.writeAndRead()
        Toast.makeText(this, this.isExternalWritable().toString(), Toast.LENGTH_LONG).show()
    }

    private fun writeAndRead() {
        val outDir: File = getExternalFilesDir(null)!!
        val outFile: File = File(outDir, "example.txt")
        val prntStrm: PrintStream = PrintStream(outFile)
        prntStrm.println("These contents\nare written\nusing file and\nprint stream objects")
        prntStrm.close()

        // Reading

        val scan: Scanner = Scanner(openFileInput(outFile.absolutePath))
        var str: String = ""

        while (scan.hasNext()) {
            str += scan.nextLine() + "\n"
        }

        scan.close()
        findViewById<TextView>(R.id.writtenContents).text = str
    }

    private fun isExternalWritable(): Boolean {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
    }

    private fun isExternalReadable(): Boolean {
        return (isExternalWritable() || Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState()))
    }
}