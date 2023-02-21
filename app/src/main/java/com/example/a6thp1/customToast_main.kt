package com.example.a6thp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class customToast_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toast_main)

        val btn= findViewById<Button>(R.id.btnToast)
        btn.setOnClickListener {
            val vg:ViewGroup?= findViewById(R.id.cl)
            val layout=layoutInflater
            val v:View=layout.inflate(R.layout.customtoast_list,vg)
            val tv=v.findViewById<TextView>(R.id.txtVw)
            tv.setText("Demo of Custom Toast Layout")
            val toast=Toast(applicationContext)
            toast.duration=Toast.LENGTH_LONG
            toast.setGravity(Gravity.CENTER_VERTICAL,0,100)
            toast.view=v
            toast.show()
        }
    }
}