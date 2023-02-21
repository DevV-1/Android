package com.example.a6thp1

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts


class Image_display : AppCompatActivity() {
    lateinit var uploadImage: Button
    lateinit var iv: ImageView
    lateinit var filepath: Uri
    lateinit var clickImage: Button
    val picid = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_display)
        uploadImage = findViewById(R.id.btn_upload_image)
        clickImage = findViewById(R.id.btn_click_image)

        iv = findViewById(R.id.image_preview)

        val ip = registerForActivityResult(ActivityResultContracts.GetContent())
        {
            filepath = it!!
            iv.setImageURI(it)
        }
        uploadImage.setOnClickListener() {
            ip.launch("image/*")

        }

        clickImage.setOnClickListener {
            val i = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
                Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            } else {

            }
            startActivityForResult(i as Intent?, picid)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == picid) {
            val b = data!!.extras!!["data"] as Bitmap?
            iv.setImageBitmap(b)
        }
    }
}

