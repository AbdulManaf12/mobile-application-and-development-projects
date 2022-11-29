package com.example.networkoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread(Runnable {
            try {
                // Step-1
                val url_string: String = "https://www.tutorialspoint.com/json/data.json"
                val url: URL = URL(url_string)
                // Step-2
                val connection: HttpsURLConnection = url.openConnection() as HttpsURLConnection
                // Step-3
                connection.connect()
                // Step-4
                val read = BufferedReader(InputStreamReader(connection.inputStream))
                var line : String? = read.readLine()
                var dataText: String = ""
                while (line != null) {
                    dataText += line
                    line = read.readLine()
                }
                //Toast.makeText(this, dataText, Toast.LENGTH_LONG).show()
                Log.d("Data: ", dataText)
                // Step-5
                connection.disconnect()
            } catch (e: Exception) {
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
            }
        }).start()
    }
}