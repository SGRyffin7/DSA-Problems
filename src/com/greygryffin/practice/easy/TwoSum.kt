package com.greygryffin.practice.easy

//https://leetcode.com/problems/two-sum/

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()

    for(i in nums.indices) {
        if(map.containsKey(target-nums[i])) {
            return intArrayOf(map.get(target-nums[i])!!, i)
        } else {
            map[nums[i]] = i
        }
    }

    return intArrayOf()
}