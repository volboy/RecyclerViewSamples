package com.mmurtazaliev.recyclerviewsamples

object DaysRepository {
    val days = mutableListOf<Day>()
    private val emptySpace = mutableListOf<Day>()

    init {
        repeat(31) {
            days.add(Day(number = it))
        }
        repeat(7) {
            emptySpace.add(Day(number = 0))
        }
        days.addAll(0, emptySpace)
        days.addAll(emptySpace)
    }
}