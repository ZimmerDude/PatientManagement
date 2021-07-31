package com.mysterio.cowin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_search_cont.*

class searchCont : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_cont)
        details.setOnClickListener {
            var i = Intent(this, patientrecords::class.java)
            val phno=phntext.text.toString()
            i.putExtra("phno",phno)
            startActivity(i)

        }
    }
}