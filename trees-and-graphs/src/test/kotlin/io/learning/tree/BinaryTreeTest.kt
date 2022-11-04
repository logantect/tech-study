package io.learning.tree

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/*
*      1
*    /  \
*    2   3
*  /  \
* 4    5
* InOrder(Left -> Root -> Right): 4 2 5 1 3
* PreOrder(Root -> Left -> Right): 1 2 4 5 3
* PostOrder(Left -> Right -> Root): 4 5 2 3 1
* 자기자신을 먼저 출력: PreOrder
* 자기자신을 나중에 출력: PostOrder
*/

internal class BinaryTreeTest {

    private lateinit var binaryTree: BinaryTree

    @BeforeEach
    internal fun setUp() {
        this.binaryTree = BinaryTree()
        val n4 = binaryTree.makeNode(null, 4, null)
        val n5 = binaryTree.makeNode(null, 5, null)
        val n2 = binaryTree.makeNode(n4, 2, n5)
        val n3 = binaryTree.makeNode(null, 3, null)
        val n1 = binaryTree.makeNode(n2, 1, n3)
        binaryTree.root = n1
    }

    @Test
    internal fun `InOrder 탐색`() {
        binaryTree.inOrder(binaryTree.root)
        Assertions.assertThat(binaryTree.result).containsExactly(4, 2, 5, 1, 3)
    }

    @Test
    internal fun `PreOrder 탐색`() {
        binaryTree.preOrder(binaryTree.root)
        Assertions.assertThat(binaryTree.result).containsExactly(1, 2, 4, 5, 3)
    }

    @Test
    internal fun `PostOrder 탐색`() {
        binaryTree.postOrder(binaryTree.root)
        Assertions.assertThat(binaryTree.result).containsExactly(4, 5, 2, 3, 1)
    }
}