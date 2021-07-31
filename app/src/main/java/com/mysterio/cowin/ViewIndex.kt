package com.mysterio.cowin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ViewIndex : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_index)
    }
    fun viewpatient(v: View?){
        var i = Intent(this, viewpatientdata::class.java)
        startActivity(i)
    }
    fun vaccination(v: View?){
        var i = Intent(this, viewpatientdata::class.java)
        startActivity(i)
    }
}