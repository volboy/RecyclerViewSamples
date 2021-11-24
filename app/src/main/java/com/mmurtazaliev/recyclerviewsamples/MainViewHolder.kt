package com.mmurtazaliev.recyclerviewsamples

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val title: TextView = view.findViewById(R.id.title)

    fun bind(day: Day) {
        title.text = day.number.toString()
    }
}