package com.example.challenges.greedy

fun main() {
    println(minimumWaitingTime(mutableListOf(3,2,1,2,6)))
}

fun minimumWaitingTime(queries: MutableList<Int>): Int {
    queries.sort()
    var sum = 0
   for (q in 0 until queries.size) {
       val duration = queries[q]
       val queriesLeft = queries.size - (q + 1)
       sum += duration * queriesLeft
   }
    return  sum
}