package com.example.challenges.searching

/*{
    "array": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],
    "target": 33
}*/
fun main() {
    val array = listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73) //sorted array
    val target = 33
    val expected = 3 //index of the target 33

    val result = binarySearch(array, target)
//    println(result == expected)
    println(result)
}

// O(log(n)) time | O(1) space
fun binarySearch(array: List<Int>, target: Int): Int {
    var left = 0
    var right =  array.size - 1

    while (left <= right) {
        val middle = (left + right) / 2

        val match = array[middle]

        if (match == target) {
            return middle
        } else if (target < match) {
            right = middle -1
        } else {
            left = middle + 1
        }
    }

    return -1
}