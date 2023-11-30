package com.example.projtigerfud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AsianActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asian)

            val imageList = listOf<Image>(
                Image(
                    R.drawable.dimsumasn,
                    TFChickenDetailActivity::class.java
                ),
                Image(
                    R.drawable.angkongasn,
                    ChickenActivity::class.java
                ),
                Image(
                    R.drawable.yoshiasn,
                    ChickenActivity::class.java
                ),
                Image(
                    R.drawable.illoasn,
                    ChickenActivity::class.java
                ),
                Image(
                    R.drawable.kyukyuasn,
                    ChickenActivity::class.java
                ),
            )

            val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView4)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ImageAdapter(this, imageList) { selectedImage ->
                // Use the selectedImage to get the class reference dynamically
                val intent = Intent(this, selectedImage.activityClass)
                startActivity(intent)
            }
        }
    }
