package com.example.projtigerfud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TapaKingDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tapa_king_detail)
    }

    fun backBtnClick (view: View){
        val intent= Intent(this, FastfoodActivity::class.java)
        startActivity(intent)
    }
}