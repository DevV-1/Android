package com.example.a6thp1

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class alarm2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm2)

        var start = findViewById<Button>(R.id.button)
        var repeat = findViewById<Button>(R.id.Rstart)
        var et = findViewById<EditText>(R.id.time)
        var alarmManager: AlarmManager
        var cancel = findViewById<Button>(R.id.cancel_button)
        val i = Intent(this, MyBroadcastDemo::class.java)
        var pendingIntent = PendingIntent.getBroadcast(
            this,
            0, i, PendingIntent.FLAG_UPDATE_CURRENT
        )
        start.setOnClickListener {
            var l = et.text.toString().toInt()
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + (l * 1000), pendingIntent
            )
            Toast.makeText(this, "Alarm  set", Toast.LENGTH_LONG).show()
        }
        repeat.setOnClickListener {
            val e = et.text.toString().toInt()
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 5000, pendingIntent
            )
            Toast.makeText(this, "Repeat Alarm is Set ", Toast.LENGTH_LONG).show()

        }
            cancel.setOnClickListener {
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this, "Alarm Cancelled ", Toast.LENGTH_LONG).show()

        }
    }

}

class MyBroadcastDemo : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val mp = MediaPlayer.create(p0, R.raw.alarm)
        mp.start()
        Log.d("Hello", "AlarmRinging")

    }
}

