package com.example.challenges.binary.search.trees

import kotlin.math.abs

/*{
    "tree": {
    "nodes": [
    {"id": "10", "left": "5", "right": "15", "value": 10},
    {"id": "15", "left": "13", "right": "22", "value": 15},
    {"id": "22", "left": null, "right": null, "value": 22},
    {"id": "13", "left": null, "right": "14", "value": 13},
    {"id": "14", "left": null, "right": null, "value": 14},
    {"id": "5", "left": "2", "right": "5-2", "value": 5},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": null, "value": 2},
    {"id": "1", "left": null, "right": null, "value": 1}
    ],
    "root": "10"
},
    "target": 12
}
Avg time: O(log(n)) - n is the number of nodes - for most BST insertion, removal, searching because we remove half of the tree to explore nodes
Worst case time complexity: O(n) - tree with only 1 branch (we can't eliminate half

space complexity: 2 possibilities
O(log(n)): frames on the call stack - recursion - using extra memory (n is the deph of the tree)
worse case: O(n) - for 1 branch tree
Iterative solution: O(1) - constant because is storing closest value and current value (not using frame call stack)
Iterative solution is better for space complexity

without abs()
10: 2 > 2
15: 2 > -3
13: -3 > -1
15

with abs()
10: 2 > 2
15: 2 > 3
13: 2 > 1
13
*/
fun main() {
    val tree = BST(10)
    tree.left = BST(5)
    tree.left!!.left = BST(2)
    tree.left!!.left!!.left = BST(1)
    tree.left!!.right = BST(5)
    tree.right = BST(15)
    tree.right!!.left = BST(13)
    tree.right!!.left!!.right = BST(14)
    tree.right!!.right = BST(22)

    val target = 12

    println(findClosestValueInBst(tree, target))
}

fun findClosestValueInBst(tree: BST, target: Int): Int =
    find(tree, target, tree.value)

fun find(tree: BST, target: Int, closest: Int): Int {
    var newClosest = closest

    println("${tree.value}: ${abs(target - closest)} > ${abs(target - tree.value)}")
    if (abs(target - closest) > abs(target - tree.value)) {
        newClosest = tree.value
    }

    return when {
        target < tree.value && tree.left != null -> find(tree.left!!, target, newClosest)
        target > tree.value && tree.right != null -> find(tree.right!!, target, newClosest)
        else -> newClosest
    }
}

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}