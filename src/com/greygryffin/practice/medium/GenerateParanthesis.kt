package com.greygryffin.practice.medium

//https://leetcode.com/problems/generate-parentheses/description/

fun main() {
    parenthesis(
        target = 3,
        cOpen = 0,
        cClose = 0,
        cur = "",
        mem = mutableListOf()
    )
}

private fun parenthesis(target: Int, cOpen: Int, cClose: Int, cur: String, mem: MutableList<String>): MutableList<String> {
    if(cOpen<0 || cClose<0 || cClose>cOpen) return mutableListOf()

    when {
        cur.length == target * 2 -> {
            mem.add(cur)
        }

        cOpen < target -> {
            parenthesis(target, cOpen + 1, cClose, "$cur(", mem)
            if (cClose < cOpen)
                parenthesis(target, cOpen, cClose + 1, "$cur)", mem)
        }

        cClose < cOpen -> {
            mem.add("$cur${")".repeat(target - cClose)}")
        }
    }

    return mem

}