package com.example.a6thp1;
import android.app.AlarmManager
import android.app.AlarmManager.RTC_WAKEUP
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.util.Log

class MyJobService :JobService(){


    override fun onStartJob(p0: JobParameters?): Boolean {
        val i= Intent(this,AlarmManagerBroadcast::class.java)
        val pi=PendingIntent.getBroadcast(this,23,i,0)
        val am=getSystemService(ALARM_SERVICE) as AlarmManager
        am.set(AlarmManager.RTC_WAKEUP,10,pi)
        return true

    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("Job","Stopped")
        return true
    }
}