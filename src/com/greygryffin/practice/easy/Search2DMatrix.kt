package com.greygryffin.practice.easy

//https://leetcode.com/problems/search-a-2d-matrix/
/**Better Solution is Double Binary Search**/

fun main() {
//    val input = arrayOf(
//        intArrayOf(1, 3, 5, 7),
//        intArrayOf(10, 11, 16, 20),
//        intArrayOf(23, 30, 34, 60),
//    )

    val input = arrayOf(
        intArrayOf(1), intArrayOf(3)
    )

    println(search(input, 3))

}

fun search(matrix: Array<IntArray>, target: Int): Any {

    if (target < matrix[0][0] || target > matrix[matrix.lastIndex][matrix[matrix.lastIndex].lastIndex])
        return false

    var i = 0
    var j = 0

    while (i != matrix.lastIndex && matrix[i + 1][0] <= target) {
        i++
    }

    while (j < matrix[i].size) {
        if (matrix[i][j] > target)
            return false
        else if (matrix[i][j] == target)
            return true
        else
            j++
    }

    return false

}
