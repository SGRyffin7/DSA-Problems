package com.greygryffin.practice.medium

fun main() {
    val input = intArrayOf(7,1,5,3,6,4)
    println(maxProfit(input))
}

private fun maxProfit(input: IntArray): Int {
    var lastLow = Integer.MAX_VALUE
    var sum = 0
    for (day in input) {
        if(lastLow <= day) sum += day - lastLow
        lastLow = day
    }

    return sum
}
