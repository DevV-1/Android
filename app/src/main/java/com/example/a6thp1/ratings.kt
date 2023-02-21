package com.example.a6thp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Button
import android.widget.Toast
import android.widget.RatingBar.OnRatingBarChangeListener
import android.view.View

class ratings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratings)

        val simpleRatingBar:RatingBar=findViewById(R.id.simpleRatingBar)
        val simpleRating:RatingBar=findViewById(R.id.simpleRating)
        val submitButton= findViewById<Button>(R.id.sumbitButton)

        submitButton.setOnClickListener {
            val totalStars="Total Stars:: "+simpleRatingBar.numStars
            val rating="Rating:: "+simpleRatingBar.rating
            Toast.makeText(this@ratings, """$totalStars$rating""".trimIndent(),Toast.LENGTH_LONG).show()
        }

        simpleRating.onRatingBarChangeListener= OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                Toast.makeText(this@ratings, "rating$rating", Toast.LENGTH_SHORT).show()
            }
    }
}


