package com.example.challenges.arrays

fun main() {
    val coins = mutableListOf(5,7,1,1,2,3,22) // return 20
    println(nonConstructibleChange(coins))
}

/*
[1,2,5]
- loop
- verify minimum amount not in the array to give as a change
- sort it
- loop
- verify array position is greater than max amount +1 (opposite minimun amount)
- increase aux number
- O(nlogn) time and O(1) space
*/
fun nonConstructibleChange(coins: MutableList<Int>): Int {
    coins.sort()
    println(coins)
    var maxAmountAux = 0
    for(i in coins) {
        if (i > maxAmountAux + 1) {
            println("here: ${i}")
            println("here: ${maxAmountAux} + 1")
            return maxAmountAux + 1
        }
        maxAmountAux += i
        println(maxAmountAux)
    }

    return maxAmountAux + 1
}