package com.example.challenges.arrays

fun main() {
    val array = listOf(1,2,3,5,6,8,9)
    println(sortedSquaredArray(array))
}

/*
* map array, get square of the original and sort it back to return
* */
fun sortedSquaredArray(array: List<Int>): List<Int> =
    array.map { it * it }.sorted()
