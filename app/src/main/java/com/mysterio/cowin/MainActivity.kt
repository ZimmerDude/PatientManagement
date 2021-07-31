package com.mysterio.cowin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    private fun validate(u:String, p:String): Boolean {
        if (u == "AndroidDEV" && p == "LOGINFREE")
            return true
        return false
    }
    fun login(v: View?){
        var uname = findViewById<EditText>(R.id.username)
        var pword = findViewById<EditText>(R.id.password)
        if (validate(uname.text.toString(), pword.text.toString())){
            Toast.makeText(this,"Login successful",Toast.LENGTH_LONG).show()
            var i =Intent(this, Home::class.java)
            startActivity(i)
            finish()
        }
        else {
            Toast.makeText(this,"Invalid Username/Password", Toast.LENGTH_LONG).show()
        }
    }
}
