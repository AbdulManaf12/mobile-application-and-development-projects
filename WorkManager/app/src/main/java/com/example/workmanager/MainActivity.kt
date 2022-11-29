package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ClickMe(view: View){
        val data = Data.Builder().putString("name", "Abdul Manaf").build()

        // creating work request
        val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.UNMETERED).build()

        val request = OneTimeWorkRequest.Builder(TestWork::class.java).
            setInputData(data).setConstraints(constraints).build()

        // Add workrequest in WorkManager
        WorkManager.getInstance(this).enqueue(request)

    }
}