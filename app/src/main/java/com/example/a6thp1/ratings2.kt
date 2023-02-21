package com.example.a6thp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class ratings2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratings2)

        val simpleRatingBar1: RatingBar =findViewById(R.id.simpleRatingBar1)
        val simpleRatingBar2: RatingBar =findViewById(R.id.simpleRatingBar2)
        val simpleRatingBar3: RatingBar =findViewById(R.id.simpleRatingBar3)
        val simpleRatingBar4: RatingBar =findViewById(R.id.simpleRatingBar4)
        val simpleRatingBar5: RatingBar =findViewById(R.id.simpleRatingBar5)
        val sumbitButton= findViewById<Button>(R.id.sumbitButton)
//
        sumbitButton.setOnClickListener {
            val totalStars="Total Stars:: "+simpleRatingBar1.numStars
            val rating1="Rating:: "+simpleRatingBar1.rating
            val rating2="Rating:: "+simpleRatingBar2.rating
            val rating3="Rating:: "+simpleRatingBar3.rating
            val rating4="Rating:: "+simpleRatingBar4.rating
            val sum=rating1+rating2+rating3+rating4
            Toast.makeText(this@ratings2, """$totalStars$sum""".trimIndent(), Toast.LENGTH_LONG).show()
        }

        simpleRatingBar1.onRatingBarChangeListener=
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                Toast.makeText(this@ratings2, "rating$ratingBar to rating$rating $fromUser", Toast.LENGTH_SHORT).show()
            }
        simpleRatingBar2.onRatingBarChangeListener=
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                Toast.makeText(this@ratings2, "rating$ratingBar to rating$rating $fromUser", Toast.LENGTH_SHORT).show()
            }
        simpleRatingBar3.onRatingBarChangeListener=
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                Toast.makeText(this@ratings2, "rating$ratingBar to rating$rating", Toast.LENGTH_SHORT).show()
            }
        simpleRatingBar4.onRatingBarChangeListener=
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                Toast.makeText(this@ratings2, "rating$ratingBar to rating$rating", Toast.LENGTH_SHORT).show()
            }
    }
}