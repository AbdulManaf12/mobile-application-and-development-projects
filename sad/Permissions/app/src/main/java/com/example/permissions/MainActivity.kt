package com.example.permissions

import android.app.ActivityManager
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.req_btn).setOnClickListener {
            this.requestPermissions()
        }
    }

    private fun hasWriteExternalStoragePermission() =
        ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun hasInternetPermission() =
        ActivityCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED

    private fun hasForegroundPermission() =
        ActivityCompat.checkSelfPermission(this, android.Manifest.permission.FOREGROUND_SERVICE) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForegroundPermission() =
        ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    fun requestPermissions() {
        val permissionsToRequest = mutableListOf<String>()
        if (!this.hasWriteExternalStoragePermission()) {
            permissionsToRequest.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!this.hasForegroundPermission()) {
            permissionsToRequest.add(android.Manifest.permission.FOREGROUND_SERVICE)
        }
        if(!this.hasInternetPermission()) {
            permissionsToRequest.add(android.Manifest.permission.INTERNET)
        }
        if(!this.hasLocationForegroundPermission()) {
            permissionsToRequest.add(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if (permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
        }
    }


    // To Handle the result when the user either grants or denies the request
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("GrantedPermissions", "${permissions[i]}")
                }
            }
        }
    }
}