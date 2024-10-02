package com.greygryffin.practice.medium

//https://leetcode.com/problems/number-of-1-bits/submissions/1407320448/

fun main() {
    println(count1Bits(3333))
}

private fun count1Bits(i: Int): Int {
    var count = 0
    var n = i
    while(n>0) {
        if (n%2 == 1) count++
        n /= 2
    }
    return count
}
