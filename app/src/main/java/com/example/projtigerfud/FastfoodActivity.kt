package com.example.projtigerfud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
                ArmynavyDetailActivity::class.java
            ),
            Image(
                R.drawable.bonff,
                BonchonDetailActivity::class.java
            ),
            Image(
                R.drawable.mcdoff,
                McdoDetailActivity::class.java
            ),
            Image(
                R.drawable.chowkingff,
                chowkingDetailActivity::class.java
            ),
            Image(
                R.drawable.tapakingff,
                TapaKingDetailActivity::class.java
            ),
        )

        fun backBtnClick (view: View){
            val intent= Intent(this, MainCategory::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView3)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ImageAdapter(this, imageList) { selectedImage ->
            // Use the selectedImage to get the class reference dynamically
            val intent = Intent(this, selectedImage.activityClass)
            startActivity(intent)
    }

}
}