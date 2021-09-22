package com.example.challenges.binary.trees

/*{
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": "3", "value": 1},
    {"id": "2", "left": "4", "right": "5", "value": 2},
    {"id": "3", "left": "6", "right": "7", "value": 3},
    {"id": "4", "left": "8", "right": "9", "value": 4},
    {"id": "5", "left": "10", "right": null, "value": 5},
    {"id": "6", "left": null, "right": null, "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7},
    {"id": "8", "left": null, "right": null, "value": 8},
    {"id": "9", "left": null, "right": null, "value": 9},
    {"id": "10", "left": null, "right": null, "value": 10}
    ],
    "root": "1"
}
}
result: listOf(15, 16, 18, 10, 11)
Complexity time: O(n): traverse the tree - at every single node is constant time operations just to visiting: adding value to the node or checking
Space complexity: 2 things affecting - list of branch of sums to return + recursive nature of solution (stack)
Balanced binary tree: not a long super long branch:
Space complexity will be O(n)
worse case: tree 1 branch only: O(n) space
*/
fun main() {
    val tree = BinaryTree(1)
    tree.left = BinaryTree(2)
    tree.right = BinaryTree(3)
    tree.left!!.left = BinaryTree(4)
    tree.left!!.right = BinaryTree(5)
    tree.right!!.left = BinaryTree(6)
    tree.right!!.right = BinaryTree(7)
    tree.left!!.left!!.left = BinaryTree(8)
    tree.left!!.left!!.right = BinaryTree(9)
    tree.left!!.right!!.left = BinaryTree(10)

    println(branchSums(tree))
}

fun branchSums(tree: BinaryTree): List<Int> {
    val sumList = mutableListOf<Int>()
    find(tree, 0, sumList)
    return sumList
}

fun find(node: BinaryTree?, sum: Int, sumList: MutableList<Int>) {
    if (node == null) return
    val currentSum = sum + node.value

    if (node.left == null && node.right == null) sumList.add(currentSum)

    find(node.left, currentSum, sumList)
    find(node.right, currentSum, sumList)
}

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}