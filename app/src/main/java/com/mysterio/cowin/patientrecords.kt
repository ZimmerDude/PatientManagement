package com.mysterio.cowin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_patientrecords.*

class patientrecords : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patientrecords)
        var ph =intent.getStringExtra("phno");
        try {
            var db = DataBase(this)
            var data = db.readDaataphone(ph.toString())

            for (i in 0..(data.size - 1)) {

                idview1.text= data.get(i).id.toString()
                nameview1.text=data.get(i).name
                ageview1.text=data.get(i).age.toString()
                phoneview1.text=data.get(i).phone
                emailview1.text=data.get(i).email
                gnderview1.text=data.get(i).gender
                positiveview1.text=data.get(i).covid
                hospitalview1.text=data.get(i).hospital
                dischargeview1.text=data.get(i).discharge

            }
        } catch (e: Exception) {
            print(e.printStackTrace())

        }
    }
}