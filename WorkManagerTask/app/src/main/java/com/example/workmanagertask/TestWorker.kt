package com.example.workmanagertask

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class TestWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams){
    override fun doWork(): Result {
        MainActivity.progressbar.progress += 10
        return Result.success()
    }
}