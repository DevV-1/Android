package com.example.a6thp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class scrollview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrollview)

        setContentView(R.layout.activity_scrollview)   // vertical
//        setContentView(R.layout.activity_scrollview) // horizontal
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this@scrollview, "back pressed", Toast.LENGTH_SHORT).show()

        }

    }
