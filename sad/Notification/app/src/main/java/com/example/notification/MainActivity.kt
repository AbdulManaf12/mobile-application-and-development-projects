package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    // STEP 1: Create a notification channel. This channel that we will post our notifications in,
    // will hold the configuration we want to have for our notifications.
    // Once you set the notification channel with a certain behaviour, you cannot change it.

    // Globally, define channel id and channel name. The channel id must be unique and is used
    // to differentiate between several channels.
    val CHANNEL_ID = "myChannel"
    val CHANNEL_NAME = "notify"

    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()

        //STEP 6:
        // When you click the notification, the notification will NOT open your app.
        // This is because, the notification is actually shown by another app called notification service.
        // We need to tell it this app to execute some code in our app.

        // We achieve this by using a PENDING INTENT: Which allows another app to execute some code in our app
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        // STEP 4: Create your notification
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Awesome Notification")
            .setContentText("I hope you're having a good day today! :-)")
            .setSmallIcon(R.drawable.bell)
            .setContentIntent(pendingIntent) // Set the pending intent
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        // STEP 5: Create a notification manager combat object
        val notificationManager = NotificationManagerCompat.from(this)

        val btnShowNotification: Button = findViewById(R.id.btn_show_notification)
        btnShowNotification.setOnClickListener {
            // SIMPLY SHOW THE NOTIFICATION
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }

    // STEP 2: Create a function to actually create a notification channel with CH_ID and name
    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Notification Channel:
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            // STEP 3: Create a notification manager
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}