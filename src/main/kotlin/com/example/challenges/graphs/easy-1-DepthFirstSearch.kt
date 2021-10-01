package com.example.challenges.graphs

fun main() {
    val i = Node("I")
    val j = Node("J")
    val k = Node("K")

    val e = Node("E")
    val f = Node("F")
    f.children.addAll(listOf(i, j))

    val g = Node("G")
    g.children.add(k)

    val h = Node("H")

    val b = Node("B")
    b.children.add(e)
    b.children.add(f)

    val c = Node("C")

    val d = Node("D")
    d.children.add(g)
    d.children.add(h)

    val graph = Node("A")
    graph.children.add(b)
    graph.children.add(c)
    graph.children.add(d)

    println(graph.depthFirstSearch())
}

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun depthFirstSearch(): List<String> =
        find(mutableListOf())

    fun find(array: MutableList<String>): List<String> {
        array.add(this.name)
        for (child in this.children) {
            child.find(array)
        }
        return array
    }
}