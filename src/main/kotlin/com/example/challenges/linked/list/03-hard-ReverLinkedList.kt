package com.example.challenges.linked.list

fun main() {
    var linkedList = LinkedList(0)
    addAll(linkedList, listOf(1, 2, 3, 4, 5))

    var reversedLinkedList = LinkedList(5)
    addAll(reversedLinkedList, listOf(4, 3, 2, 1, 0))

    val result = reverseLinkedList(linkedList)
    println(result.toString())
    println(getNodeValuesInArray(reversedLinkedList) == getNodeValuesInArray(result))
}

fun addAll(ll: LinkedList, values: List<Int>) {
    var current = ll
    for (value in values) {
        val newLL = LinkedList(value)
        current.next = newLL
        current = newLL
    }
}

fun getNodeValuesInArray(linkedList: LinkedList): List<Int> {
    var values = mutableListOf<Int>()
    var current: LinkedList? = linkedList
    while (current != null) {
        values.add(current.value)
        current = current.next
    }
    return values
}

fun reverseLinkedList(head: LinkedList): LinkedList {
    var previous: LinkedList? = null
    var current: LinkedList? = head

    while (current != null) {
        val nextNode = current.next
        current.next = previous
        previous = current
        current = nextNode
    }

    return previous!!
}

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null

    override fun toString(): String {
        return "LinkedList(value=$value, next=$next)"
    }
}
/*
{
  "linkedList": {
    "head": "0",
    "nodes": [
      {"id": "0", "next": "1", "value": 0},
      {"id": "1", "next": "2", "value": 1},
      {"id": "2", "next": "3", "value": 2},
      {"id": "3", "next": "4", "value": 3},
      {"id": "4", "next": "5", "value": 4},
      {"id": "5", "next": null, "value": 5}
    ]
  }
}
 */