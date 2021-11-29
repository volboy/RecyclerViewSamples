package com.mmurtazaliev.recyclerviewsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.mmurtazaliev.recyclerviewsamples.utils.OnSnapPositionChangeListener

class MainActivity : AppCompatActivity(), OnSnapPositionChangeListener {
    private lateinit var currentPosition: TextView
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainRv = findViewById<RecyclerView>(R.id.mainRv)
        currentPosition = findViewById(R.id.currentPosition)
        mainAdapter = MainAdapter()
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        mainRv.attachSnapHelperWithListener(LinearSnapHelper(), SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL_STATE_IDLE, this)
        mainRv.layoutManager = layoutManager
        mainRv.adapter = mainAdapter
        mainAdapter.setItem(DaysRepository.days)

    }

    override fun onSnapPositionChange(position: Int) {
        val day = mainAdapter.getItem(position).number
        if (day!=0){
            currentPosition.text = day.toString()
        } else {
            currentPosition.text = ""
        }
    }

}