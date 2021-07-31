package com.mysterio.cowin

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import java.io.File


class Home : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        imageButton5.setOnClickListener {
            dispatchTakePictureIntent()
        }

    }
    fun logout(v: View?) {
        var i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
    fun insertpatient(v:View?){
        var i = Intent(this, insertPatient::class.java)
        startActivity(i)
    }
    fun search(v:View?){
        var i = Intent(this, searchCont::class.java)
        startActivity(i)
    }
    fun viewindex(v:View?){
        var i = Intent(this, ViewIndex::class.java)
        startActivity(i)
    }
    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

}