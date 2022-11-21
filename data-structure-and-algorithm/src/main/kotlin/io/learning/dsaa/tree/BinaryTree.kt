package io.learning.dsaa.tree

class BinaryTree {
    var root: Node? = null
    val result: MutableList<Int> = mutableListOf()

    fun makeNode(left: Node?, data: Int, right: Node?): Node {
        return Node(
            left = left,
            data = data,
            right = right
        )
    }

    fun inOrder(node: Node?) {
        if (node == null) {
            return
        }
        inOrder(node.left)
        result.add(node.data)
        inOrder(node.right)
    }

    fun preOrder(node: Node?) {
        if (node == null) {
            return
        }
        result.add(node.data)
        preOrder(node.left)
        preOrder(node.right)
    }

    fun postOrder(node: Node?) {
        if (node == null) {
            return
        }
        postOrder(node.left)
        postOrder(node.right)
        result.add(node.data)
    }

    class Node(
        val data: Int,
        val left: Node?,
        val right: Node?
    )

}