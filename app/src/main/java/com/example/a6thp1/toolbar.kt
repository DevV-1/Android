package com.example.a6thp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar

class toolbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        toolbar.setLogo(R.drawable.ic_baseline_call_24)
        toolbar.setTitle("225")
        toolbar.setSubtitle("Toolbar")
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "pressed", Toast.LENGTH_LONG).show()
        }
    }

    private fun setSupportActionBar(toolbar: Toolbar?) {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int=item.itemId
        if(id==R.id.action_settings) {
            Toast.makeText(applicationContext,"Settings", Toast.LENGTH_LONG).show()
            return true
        }
        if(id==R.id.action_email) {
            Toast.makeText(applicationContext,"Email", Toast.LENGTH_LONG).show()
            return true
        }
        if(id==R.id.action_home) {
            Toast.makeText(applicationContext,"Home", Toast.LENGTH_LONG).show()
            return true
        }
        if(id==R.id.action_message) {
            Toast.makeText(applicationContext,"Message", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}