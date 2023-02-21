package com.example.a6thp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.os.Looper

class MainSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_splash)

            /*  Handler().postDelayed(Runnable {
                  val i = Intent(this@MainActivity, SplashScreenExampleMain::class.java)
                  startActivity(i)
                  finish()
              }, 5000)
      */
            Handler(Looper.getMainLooper()).postDelayed({
                val i = Intent(this@MainSplash, SplashScreen::class.java)
                startActivity(i)
                finish()
            }, 5000)

        }
    }


