package com.mmurtazaliev.recyclerviewsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.mmurtazaliev.recyclerviewsamples.utils.OnSnapPositionChangeListener

class MainActivity : AppCompatActivity() {
    private lateinit var currentPosition: TextView

    private object onSnapPositionChangeListener : OnSnapPositionChangeListener {
        override fun onSnapPositionChange(position: Int) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainRv = findViewById<RecyclerView>(R.id.mainRv)
        currentPosition = findViewById(R.id.currentPosition)
        val mainAdapter = MainAdapter()
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val snapHelper = LinearSnapHelper().also { it.attachToRecyclerView(mainRv) }
        val snapOnScrollListener = SnapOnScrollListener(snapHelper, this)
        mainRv.layoutManager = layoutManager
        mainRv.adapter = mainAdapter
        mainAdapter.setItem(DaysRepository.days)

    }

}