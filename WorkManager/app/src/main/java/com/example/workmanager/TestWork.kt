package com.example.workmanager

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.work.*

class TestWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams)
{
    override fun doWork(): Result {
        val handler = Handler(Looper.getMainLooper())
        handler.post{
            Toast.makeText(applicationContext, "Hello  ${inputData.getString("name")}", Toast.LENGTH_LONG).show()
        }
        return Result.success()
    }
}