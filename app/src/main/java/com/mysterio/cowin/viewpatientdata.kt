package com.mysterio.cowin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_viewpatientdata.*

class viewpatientdata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpatientdata)
        textView9svd.text="Id\t\tName\t\tAge\t\tPhone\t\tGender\t\tEmail\t\tCovid Positive date\t\tDate of hospitalization\t\tDate of discharge"

        try {
            var db = DataBase(this)
            var data = db.readData(1)
            for (i in 0..(data.size - 1)) {
                val linearLayout: LinearLayout = findViewById(R.id.parentLayout)
                val childpar = LinearLayout(this)
                val textview = TextView(this)
                textview.setTextColor(Color.parseColor("#000000"))
                textview.text = data.get(i).id.toString()+"\t\t"
                childpar.addView(textview)

                val textview2 = TextView(this)
                textview2.setTextColor(Color.parseColor("#000000"))
                textview2.text = data.get(i).name+"\t\t"
                childpar.addView(textview2)

                val textview3 = TextView(this)
                textview3.setTextColor(Color.parseColor("#000000"))
                textview3.text = data.get(i).age.toString()+"\t\t"
                childpar.addView(textview3)

                val textview4 = TextView(this)
                textview4.setTextColor(Color.parseColor("#000000"))
                textview4.text = data.get(i).phone+"\t\t"
                childpar.addView(textview4)

                val textview5 = TextView(this)
                textview5.setTextColor(Color.parseColor("#000000"))
                textview5.text = data.get(i).gender+"\t\t"
                childpar.addView(textview5)

                val textview7 = TextView(this)
                textview7.setTextColor(Color.parseColor("#000000"))
                textview7.text = data.get(i).covid+"\t\t"
                childpar.addView(textview7)

                val textview8 = TextView(this)
                textview8.setTextColor(Color.parseColor("#000000"))
                textview8.text = data.get(i).hospital+"\t\t"
                childpar.addView(textview8)

                val textview9 = TextView(this)
                textview9.setTextColor(Color.parseColor("#000000"))
                textview9.text = data.get(i).discharge+"\t\t"
                childpar.addView(textview9)

                val parms = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                parentLayout.addView(childpar)
            }
        } catch (e: Exception) {
            print(e.printStackTrace())
        }
    }
}