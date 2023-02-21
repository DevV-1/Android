package com.example.a6thp1

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.TimePicker
import android.widget.Toast
import java.util.*

class timepicker : AppCompatActivity() {
    lateinit var setAlarm:Button
    lateinit var cancelAlarm:Button
    lateinit var tp:TimePicker
    lateinit var alarmManager:AlarmManager
    lateinit var pendingIntent: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timepicker)
        tp=findViewById(R.id.tp)
        setAlarm=findViewById(R.id.buttonAlarm)
        cancelAlarm=findViewById(R.id.cancel)

        setAlarm.setOnClickListener {
            var calender:Calendar= Calendar.getInstance()
            if(Build.VERSION.SDK_INT>=23) {
                calender.set(calender.get(Calendar.YEAR),
                    calender.get(Calendar.MONTH),
                    calender.get(Calendar.DAY_OF_MONTH),
                tp.hour, tp.minute,0)
            }
            else {
                calender.set(calender.get(Calendar.YEAR),
                    calender.get(Calendar.MONTH),
                    calender.get(Calendar.DAY_OF_MONTH),
                    tp.currentHour,tp.currentMinute,0)
            }
            setAlarm(calender.timeInMillis)
        }
    }

    fun setAlarm(timeInMillis:Long)
    {
        alarmManager=getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val Intent=Intent(this,MyAlarm::class.java)
        pendingIntent=PendingIntent.getBroadcast(this,0,intent,0)
        alarmManager.setRepeating(AlarmManager.RTC,timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent)
        Toast.makeText(this,"Alarm is set", Toast.LENGTH_LONG).show()
    }
}


class MyAlarm:BroadcastReceiver()
{

        override fun onReceive(p0: Context?, p1: Intent?) {
            var mp = MediaPlayer.create(p0, R.raw.alarm)

            Log.d("Hello","repeating alarm")
            mp.start()
            Toast.makeText(p0,"Alarm is Ringing",Toast.LENGTH_LONG).show()
        }
    }
