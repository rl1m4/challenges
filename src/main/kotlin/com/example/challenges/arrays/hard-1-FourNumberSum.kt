package com.example.challenges.arrays

/*
* Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
* 0 <= a, b, c, d < n
* a, b, c, and d are distinct.
* nums[a] + nums[b] + nums[c] + nums[d] == target
* You may return the answer in any order
* */
fun main() {
    val nums = mutableListOf(7,6,4,-1,1,2) //target=16 output [[7, 6, 4, -1], [7, 6, 1, 2]]
    val nums1 = mutableListOf(1, 2, 3, 4, 5, -5, 6, -6) //target = 5 output [[2, 3, 5, -5], [1, 4, 5, -5], [2, 4, 5, -6], [1, 3, -5, 6], [2, 3, 6, -6], [1, 4, 6, -6]]
    println(fourSum(nums1, 5))
}

fun fourSum(array: MutableList<Int>, target: Int): List<List<Int>> {
    val pairs :MutableMap<Int, MutableList<MutableList<Int>>>  = mutableMapOf<Int, MutableList<MutableList<Int>>>()
    val result = mutableListOf<MutableList<Int>>()

    for (i in 0 until array.size) {
        for (j in i + 1 until array.size) {
            val currentSum = array[i] + array[j]
            val difference = target - currentSum
            if (pairs.containsKey(difference)) {
                for (pair in pairs[difference]!!) {
                    val p = pair.toMutableList()
                    p.add(array[i])
                    p.add(array[j])
                    result.add(p)
                    println("FIRST FOR result: $result")
                }
            }
        }
        for (k in 0 until i) {
            val currentSum = array[i] + array[k]
            if (!pairs.containsKey(currentSum)) {
                pairs[currentSum] = mutableListOf<MutableList<Int>>()
                println("HERE i ${array[i]}")
                println("HERE k ${array[k]}")
                pairs[currentSum]!!.add(mutableListOf<Int>(array[k], array[i]))
                println("SECOND FOR pairs: $pairs")
            } else {
                pairs[currentSum]!!.add(mutableListOf<Int>(array[k], array[i]))
            }
        }
    }

//    array.toSet().sorted()

    return result
}