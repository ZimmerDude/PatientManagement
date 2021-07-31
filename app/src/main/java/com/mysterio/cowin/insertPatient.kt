package com.mysterio.cowin

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insert_patient.*
import java.util.*

class insertPatient : AppCompatActivity() {
    val context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_patient)
        discharge.setOnClickListener { view ->
            datepick(view)
        }
        covid.setOnClickListener { view ->
            datepick1(view)
        }
        hospital.setOnClickListener { view ->
            datepick2(view)
        }

        hello.setOnClickListener {


            if (name.text.toString().isNotEmpty() && age.text.toString().isNotEmpty()
                && email.text.toString().isNotEmpty() && phone.text.toString().isNotEmpty()
                && gender.text.toString().isNotEmpty() && covid.text.toString().isNotEmpty()
                && hospital.text.toString().isNotEmpty() && discharge.text.toString().isNotEmpty() && emailval()==1
            ) {

                val user = User(name.text.toString(), age.text.toString().toInt(),email.text.toString(),
                    phone.text.toString(),gender.text.toString(),covid.text.toString(),hospital.text.toString() ,
                    discharge.text.toString())
                try {


                    val db = DataBase(context)

                    db.insertdata(user)
                }
                catch (e:Exception)
                {
                    print((e.printStackTrace()))
                }

            }
            else
                Toast.makeText(this, "Please Enter Details", Toast.LENGTH_LONG).show()

        }

    }

    private fun emailval(): Any {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val dd=email.text
        if (dd.matches(emailPattern.toRegex())) {
            return 1
        }
        else { Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            return 0
        }
    }

    fun datepick(view: View) {

        val mycalendar = Calendar.getInstance()
        val year = mycalendar.get((Calendar.YEAR))
        val month = mycalendar.get((Calendar.MONTH))
        val day = mycalendar.get((Calendar.DAY_OF_MONTH))

        val dpd =  DatePickerDialog(this,
            { view, selectedyear, selectedmonth, selecteddayOfMonth ->
                val selecteddate = "$selecteddayOfMonth/${selectedmonth+1 }/$selectedyear"
                discharge.setText(selecteddate)
            }, year, month, day)

        dpd.datePicker.setMaxDate(Date().time)
        dpd.show()
    }
    fun datepick1(view: View) {

        val mycalendar = Calendar.getInstance()
        val year = mycalendar.get((Calendar.YEAR))
        val month = mycalendar.get((Calendar.MONTH))
        val day = mycalendar.get((Calendar.DAY_OF_MONTH))

        val dpd =  DatePickerDialog(this,
            { view, selectedyear, selectedmonth, selecteddayOfMonth ->
                val selecteddate = "$selecteddayOfMonth/${selectedmonth+1 }/$selectedyear"
                covid.setText(selecteddate)
            }, year, month, day)

        dpd.datePicker.setMaxDate(Date().time)
        dpd.show()
    }
    fun datepick2(view: View) {

        val mycalendar = Calendar.getInstance()
        val year = mycalendar.get((Calendar.YEAR))
        val month = mycalendar.get((Calendar.MONTH))
        val day = mycalendar.get((Calendar.DAY_OF_MONTH))

        val dpd =  DatePickerDialog(this,
            { view, selectedyear, selectedmonth, selecteddayOfMonth ->
                val selecteddate = "$selecteddayOfMonth/${selectedmonth+1 }/$selectedyear"
                hospital.setText(selecteddate)
            }, year, month, day)

        dpd.datePicker.setMaxDate(Date().time)
        dpd.show()
    }
    }