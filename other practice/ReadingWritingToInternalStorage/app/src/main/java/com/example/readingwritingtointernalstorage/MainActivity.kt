package com.example.readingwritingtointernalstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.PrintStream
import java.util.Scanner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.readAndSetNames()
        this.getFilesAndCacheDir()
        this.writeAFile(
            "These contents should be written in the file called out.txt\nHello\nHow are you?\nGood bye!"
        )
    }

    private fun readAndSetNames() {
        val namesField: TextView = findViewById(R.id.names)
        val scan: Scanner = Scanner(resources.openRawResource(R.raw.boxers))
        var boxerNames: String = ""
        var indexer = 1

        while(scan.hasNext()) {
            boxerNames += "${indexer++}.  ${scan.nextLine()}\n"
        }

        scan.close()
        namesField.text = boxerNames
    }

    private fun getFilesAndCacheDir() {
        val dirsField: TextView = findViewById(R.id.dirs)
        val path: String = filesDir.path
        val cacheDir: String = cacheDir.absolutePath

        dirsField.text = "Current Path:\n${path}\n\nCache Dir:\n${cacheDir}"
    }

    private fun writeAFile(content: String) {

        // Write the contents:
        val writtenContentsField: TextView = findViewById(R.id.writtenContents)
        val output: PrintStream = PrintStream(openFileOutput("out.txt", MODE_PRIVATE))
        output.println(content)
        output.close()

        // Read it back:
        val scan: Scanner = Scanner(openFileInput("out.txt"))
        var str: String = ""

        while(scan.hasNext()) {
            str += scan.nextLine() + "\n"
        }

        scan.close()
        writtenContentsField.text = str
    }
}