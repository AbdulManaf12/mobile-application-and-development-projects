package com.example.exampractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoWidgets(view : View){
        val intent : Intent = Intent(this, WidgetsPractice::class.java)
        intent.putExtra("Title", "Widgets")
        startActivityForResult(intent, 123)
    }

    fun gotoLayouts(view: View){
        startActivity(Intent(this, LayoutPractice::class.java))
    }

    fun gotoActivityLifeCycle(view: View){
        startActivity(Intent(this, ActivityLifeCycleExample::class.java))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 123){
            val temp : String? = data?.getStringExtra("Message")
            Toast.makeText(this, temp, Toast.LENGTH_LONG).show()
        }
    }

    fun openCamera(view: View){
        startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
    }
}