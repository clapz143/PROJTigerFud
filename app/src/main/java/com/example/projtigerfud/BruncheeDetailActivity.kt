package com.example.projtigerfud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class BruncheeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brunchee_detail)
    }

    fun backBtnClick (view: View){
        val intent= Intent(this, ChickenActivity::class.java)
        startActivity(intent)
    }
}