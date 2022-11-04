package io.learning.graphs

import java.util.*

class Graph(
    private val nodes: Array<Node>
) {
    val result: MutableList<Int> = mutableListOf()

    constructor(size: Int) : this(Array(size) { i -> Node(i) })

    fun addEdge(i1: Int, i2: Int) {
        val n1 = nodes[i1]
        val n2 = nodes[i2]
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2)
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1)
        }
    }

    fun dfs() {
        dfs(0)
    }

    private fun dfs(index: Int) {
        val root = nodes[index]
        val stack = Stack<Node>()
        stack.push(root)
        root.marked = true
        while (stack.isNotEmpty()) {
            val r = stack.pop()
            r.adjacent.forEach {
                if (!it.marked) {
                    it.marked = true
                    stack.push(it)
                }
            }
            visit(r)
        }
    }

    fun dfsR() {
        dfsR(nodes[0])
    }

    fun dfsR(r: Node?) {
        if (r == null) return
        r.marked = true
        visit(r)
        r.adjacent.forEach {
            if (!it.marked) {
                dfsR(it)
            }
        }
    }

    private fun visit(n: Node) {
        print("${n.data} ")
        result.add(n.data)
    }

    class Node(
        val data: Int,
        val adjacent: LinkedList<Node>,
        var marked: Boolean = false,
    ) {
        constructor(data: Int) : this(data, LinkedList(), false)
    }
}