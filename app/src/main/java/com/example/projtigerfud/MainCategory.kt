package com.example.projtigerfud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainCategory : AppCompatActivity() {
//ITO YUNG CARDVIEW PARA SA CATEGORIES

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_category)

    val imageList = listOf<Image>(
        Image(
            R.drawable.catchicken, ChickenActivity::class.java),
        Image(
            R.drawable.catfastfood, FastfoodActivity::class.java),
        Image(
            R.drawable.catasian,AsianActivity::class.java
        ),
        Image(
            R.drawable.catcoffee,
            CoffeeActivity::class.java
        ),
    )
            val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ImageAdapter(this, imageList) { selectedImage ->
                // Use the selectedImage to get the class reference dynamically
                val intent = Intent(this, selectedImage.activityClass)
                startActivity(intent)
//
//    val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
//    recyclerView.layoutManager = LinearLayoutManager(this)
//    recyclerView.adapter = ImageAdapter(this, imageList) {
//        val intent = Intent(this, ChickenActivity::class.java)
//        startActivity(intent)
    }
    }
}