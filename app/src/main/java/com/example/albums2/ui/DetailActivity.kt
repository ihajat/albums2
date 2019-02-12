package com.example.albums2.ui

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.albums2.R

class DetailActivity : AppCompatActivity() {

    internal lateinit var imageView: ImageView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val uri = intent.extras!!.getString("uri")

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setTitle(uri)
        }
    }
}
