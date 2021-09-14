package com.example.challenges.arrays

fun main() {
    val array = mutableListOf(3,5,-4,8,11,1,-1,6)
    val target = 10

    println(twoNumberSum(array, target))
    println(twoNumberSum2(array, target))
    println(twoNumberSum3(array, target))
}

/*
* for loop array: starting in zero
* second for loop array: starting i+1
* verify if sum of the values are equal to target
* time complexity: O(n^2) / space complexity: O(1)
* */
fun twoNumberSum(array: MutableList<Int>, target: Int): List<Int> =
    with(array) {
        for (i in 0 until size) {
            for (j in i + 1 until size) {
                if (array[i] + array[j] == target) return listOf(array[i], array[j])
            }
        }
        return listOf()
    }

/*
* traverse the array, set a val with target - array
* verify if array number has the val
* time: O(n) / space: O(n)
* */
fun twoNumberSum2(array: MutableList<Int>, target: Int): List<Int> {
    val numbers = mutableMapOf<Int, String>()
    for (number in array) {
        val match = target - number
        if (numbers.containsKey(match)) {
            return listOf(match, number)
        } else {
            numbers[number] = "ADD"
        }
    }
    return listOf()
}

/*
* sort it
* verify left with right (vals to control these values
* time: Onlog(n) / space: O(1)
* */
fun twoNumberSum3(array: MutableList<Int>, target: Int): List<Int> {
    array.sort()
    var left = 0
    var right = array.size - 1

    for (number in 0 until array.size) {
        val sum = array[left] + array[right]
        when {
            sum == target -> return listOf(array[left], array[right])
            sum < target -> left++
            else -> right--
        }
    }
    return listOf()
}