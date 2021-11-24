package com.mmurtazaliev.recyclerviewsamples

object DaysRepository {
    val days = mutableListOf<Day>()

    init {
        repeat(31) {
            days.add(Day(number = it))
        }
    }
}