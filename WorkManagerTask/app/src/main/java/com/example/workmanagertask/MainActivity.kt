package com.example.workmanagertask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.work.*

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var progressbar : ProgressBar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressbar = findViewById(R.id.progressBar)
    }

    fun increment(view : View)
    {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val request : OneTimeWorkRequest =OneTimeWorkRequest.Builder(TestWorker::class.java)
            .setConstraints(constraints)
            .build()

        val workManager: WorkManager = WorkManager.getInstance(this)
        workManager.enqueueUniqueWork("mywork", ExistingWorkPolicy.REPLACE, request)
    }
    fun queryWorkManager(view : View)
    {
        WorkManager.getInstance(this).getWorkInfosForUniqueWorkLiveData("mywork")
            .observe(this) { workInfo ->

                Log.d("WorkInfo object..","Size is :" + workInfo.size);

                if(workInfo[0].state == WorkInfo.State.SUCCEEDED) {

                    val handler= Handler(Looper.getMainLooper())
                    handler.post{
                        Toast.makeText(this,"SUCCEEDED",Toast.LENGTH_LONG).show()
                    }
                    Log.d("success","Inside success");
                }
                else if(workInfo[0].state == WorkInfo.State.ENQUEUED)
                {
                    val handler= Handler(Looper.getMainLooper())
                    handler.post{
                        Toast.makeText(this,"ENQUEUED BUT HAS NOT SUCCEEDED",Toast.LENGTH_LONG).show()
                    }

                    Log.d("enqueue","Inside enqueuing");
                }
                if(!workInfo[0].state.isFinished)
                {
                    Toast.makeText(this,"Still running and waiting for to meet constraints",Toast.LENGTH_LONG).show()
                }
            }
    }
}