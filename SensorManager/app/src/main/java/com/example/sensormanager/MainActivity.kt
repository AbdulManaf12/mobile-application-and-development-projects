package com.example.sensormanager

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var text : TextView
    lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.text_view)
        image = findViewById(R.id.image)

        // Step-1: creating sensor manager
        val sm : SensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        // Step-2: creating a sensor (screen of if we take close to ear while talking on call)
        //val sensor : Sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        // Accelerometer sensor while rotating mobile x and y values change
        val sensor : Sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        // Step-3: register event for this sensor
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        val x = p0!!.values[0]
        val y = p0!!.values[1]
        text.text = "X: ${x}, Y: ${y}"

        if (!(x < 5 && y > 5)){
            image.setImageResource(R.drawable.on)
        }
        else{
            image.setImageResource(R.drawable.off)
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}