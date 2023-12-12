package com.example.projtigerfud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoffeeActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee)

        val imageList = listOf<Image>(
            Image(
                R.drawable.callecafe,
                TFChickenDetailActivity::class.java
            ),
            Image(
                R.drawable.dripkoficafe,
                ChickenActivity::class.java
            ),
            Image(
                R.drawable.manilacafe,
                ChickenActivity::class.java
            ),
            Image(
                R.drawable.cpagescafe,
                ChickenActivity::class.java
            ),
            Image(
                R.drawable.tomocafe,
                ChickenActivity::class.java
            ),
        )

        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView5)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ImageAdapter(this, imageList) { selectedImage ->
            // Use the selectedImage to get the class reference dynamically
            val intent = Intent(this, selectedImage.activityClass)
            startActivity(intent)

        }
        fun backBtnClick (view: View){
            val intent= Intent(this, MainCategory::class.java)
            startActivity(intent)
        }
    }
}