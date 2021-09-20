package com.example.challenges.leetcode

import java.util.SortedSet

/*
* Input: arrayOf("1, 3, 4, 7, 13", "1, 2, 4, 13, 15")
* Output: 1,4,13
* */
fun main() {
    val t = arrayOf("1, 3, 4, 7, 13", "1, 2, 4, 13, 15")
    println(test(t))
}

fun test(strArr: Array<String>): String {
    val first: SortedSet<Int> = strArr[0].replace(" ", "").split(",").map { it.toInt() }.toSortedSet()
    val second: SortedSet<Int> = strArr[1].replace(" ", "").split(",").map { it.toInt() }.toSortedSet()

    first.retainAll(second)

    return if (first.isEmpty()) {
        "false"
    } else {
        first.toString().replace("]", "").replace("[", "").replace(" ", "")
    }
}