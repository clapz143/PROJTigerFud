package com.example.projtigerfud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChickenActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chicken)

        val imageList = listOf<Image>(
            Image(
                R.drawable.tfchix,
                TFChickenDetailActivity::class.java
            ),
            Image(
                R.drawable.brunchee,
                BruncheeDetailActivity::class.java
            ),

            Image(
                R.drawable.raychix,
                RaysDetailActivity::class.java
            ),
            Image(
                R.drawable.tigerwinx,
                TigerwinxDetailActivity::class.java
            ),
            Image(
                R.drawable.bokchix,
                BokDetailActivity::class.java
            ),
        )

        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ImageAdapter(this, imageList) { selectedImage ->
            // Use the selectedImage to get the class reference dynamically
            val intent = Intent(this, selectedImage.activityClass)
            startActivity(intent)

        }
    }
}