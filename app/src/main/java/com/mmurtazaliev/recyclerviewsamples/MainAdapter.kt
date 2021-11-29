package com.mmurtazaliev.recyclerviewsamples

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    private val days = mutableListOf<Day>()

    fun setItem(days: List<Day>) {
        this.days.clear()
        this.days.addAll(days)
    }

    fun getItem(position:Int):Day{
        return days[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_rv, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(days[position])
    }

    override fun getItemCount() = days.size
}