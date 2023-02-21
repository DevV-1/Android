package com.example.a6thp1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast

class AlarmManagerBroadcast :BroadcastReceiver(){
    override fun onReceive(p0: Context, intent: Intent?) {
        var mp=MediaPlayer.create(p0, R.raw.alarm)
        Log.d("Hello","repeating alarm")
        mp.start()
        Toast.makeText(p0,"alarm Ringing",Toast.LENGTH_LONG).show()
    }
}