package com.greygryffin.practice.hard

import kotlin.math.max

//https://leetcode.com/discuss/interview-question/523660/maximum-profit-traveling-between-2-cities-with-associated-cost

fun main() {
    val values = arrayOf(
        intArrayOf(23, 9, 100, 37),
        intArrayOf(89, 45, 12, 44)
    )

    val costToSwitchFrom = intArrayOf(34, 77)

    val startOnA = maxProfit(values, costToSwitchFrom, 0, 0, 0)
    val startOnB = maxProfit(values, costToSwitchFrom, 0, 1, 0)
    println(max(startOnA, startOnB))
}



fun maxProfit(values: Array<IntArray>, costToSwitchFrom: IntArray, day: Int, city: Int, sum: Int): Int {
    if(day >= values[0].size)
        return sum

    val totalEarning = sum+values[city][day]
    val sumStay = maxProfit(values, costToSwitchFrom, day+1, city, totalEarning)
    val sumSwitch = maxProfit(values, costToSwitchFrom, day+1, if(city == 0) 1 else 0, totalEarning - costToSwitchFrom[city])

    return max(sumStay, sumSwitch)
}
