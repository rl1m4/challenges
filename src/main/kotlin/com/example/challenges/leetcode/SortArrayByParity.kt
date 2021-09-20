package com.example.challenges.leetcode

fun main() {
    val t = intArrayOf(3,1,2,4)
    println(sortArrayByParity(t))
    println(t.toList())
}

fun sortArrayByParity(nums: IntArray): IntArray =
    nums.sortedBy { it -> it % 2 }.toIntArray()