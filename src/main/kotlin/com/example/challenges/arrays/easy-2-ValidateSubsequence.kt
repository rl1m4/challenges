package com.example.challenges.arrays

fun main() {
    val array = listOf(5, 1, 22, 25, 6, -1, 8, 10)
    val sequence= listOf(1, 6, -1, 10)
    println(validateSubsequence(array, sequence))
}

/*
{
  "array": [5, 1, 22, 25, 6, -1, 8, 10],
  "sequence": [1, 6, -1, 10]
}
I need to verify if:
- 5 == 1: no, then
- 1 == 1: true, then
- 22 == 6: no, then
- 25 == 6: no, then
- 6 == 6: true, then
- -1 == -1: true, then
- 8 == 10: false, then
- 10 == 10: true
- break in situations where found the subsequence and don't need to run the array
*/
fun validateSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var index = 0
    for (number in array) {
        if (number == sequence.size) {
            println("break index: $index, array: $number")
            break
        }
        if (number == sequence[index]) index++
    }
    return index == sequence.size
}