package com.example.challenges.searching

/*{
    "array": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],
    "target": 33
}*/
fun main() {
    val array = listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73) //sorted array
    val target = 33
    val expected = 3 //index of 33

    val result = binarySearch(array, target)
    println(result == expected)
    println(result)
}

// O(log(n)) time | O(1) space
fun binarySearch(array: List<Int>, target: Int): Int {
    return -1
}