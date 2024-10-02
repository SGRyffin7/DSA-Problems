package com.greygryffin.practice.medium

import com.greygryffin.practice.TreeNode
import java.util.*

//https://leetcode.com/problems/invert-binary-tree/description/

private fun mirror(node: TreeNode) : TreeNode {
    val stack = Stack<TreeNode>().apply {
        push(node)
    }

    while(stack.isNotEmpty()) {
        val cur = stack.pop()
        val temp = cur.left
        cur.left = cur.right
        cur.right = temp

        if(cur.left != null) stack.push(cur.left)
        if(cur.right != null) stack.push(cur.right)
    }

    return node
}