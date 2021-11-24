package com.mmurtazaliev.recyclerviewsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainRv = findViewById<RecyclerView>(R.id.mainRv)
        val mainAdapter = MainAdapter()
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val snapHelper = LinearSnapHelper().run { attachToRecyclerView(mainRv) }
        mainRv.layoutManager = layoutManager
        mainRv.adapter = mainAdapter
        mainAdapter.setItem(DaysRepository.days)
    }
}