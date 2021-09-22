package com.example.challenges.recursion

fun main() {
    println(fib(6)) // result = 5
}

// O(2^n) time / O(n) space
fun fib(n: Int): Int =
    when (n) {
        1 -> 0
        2 -> 1
        else -> fib(n - 1) + fib(n - 2)
    }