package com.example.a6thp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.view.View

class Progressbar : AppCompatActivity() {
    private var i=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progressbar)
        val pgsBar= findViewById<ProgressBar>(R.id.pBar)
        val pgsBar1= findViewById<ProgressBar>(R.id.pBarCircular)
        val txtView= findViewById<TextView>(R.id.tView)
        val btn:Button= findViewById(R.id.btnShow)
        val btn2:Button= findViewById(R.id.btnReset)
        pgsBar1.visibility=View.INVISIBLE


        btn.setOnClickListener() {
            pgsBar1.visibility=View.VISIBLE
            i=pgsBar.progress
            Thread() {
                while (i<100) {
                    i+=1 //updating the progress bar
                    Handler(Looper.getMainLooper()).post( { //showing the progress bar
                        pgsBar.progress=i
                        txtView.text= i.toString()+ "/"+pgsBar.max
                        if (i==100) {
                            pgsBar1.visibility=View.INVISIBLE
                        }

                    })

//                    Thread.sleep(100)  //can be used

                    try {
                        Thread.sleep(100)  //to show progress slowly
                    }
                    catch (e:InterruptedException) {
                        e.printStackTrace()
                    }
            }
        }.start()

    }
        btn2.setOnClickListener() {
            pgsBar.progress=0
            txtView.text= 0.toString() + "/" + pgsBar.max
        }
}
}