package com.example.projtigerfud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FastfoodActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fastfood)

        val imageList = listOf<Image>(
            Image(
                R.drawable.armynavyff,
                TFChickenDetailActivity::class.java
            ),
            Image(
                R.drawable.bonff,
                ChickenActivity::class.java
            ),
            Image(
                R.drawable.mcdoff,
                ChickenActivity::class.java
            ),
            Image(
                R.drawable.chowkingff,
                ChickenActivity::class.java
            ),
            Image(
                R.drawable.tapakingff,
                ChickenActivity::class.java
            ),
        )

        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView3)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ImageAdapter(this, imageList) { selectedImage ->
            // Use the selectedImage to get the class reference dynamically
            val intent = Intent(this, selectedImage.activityClass)
            startActivity(intent)
    }
}
}