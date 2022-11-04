package io.learning.graphs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/*
  0
/
1 -- 3    7
|  / | \ /
| /  |  5
2 -- 4   \
          6 -- 8
-----------------------
DFS(0)
0 1 3 5 7 6 8 4 2
BFS(0)
0 1 2 3 4 5 6 7 8
DFS(0) - Recursive
0 1 2 4 3 5 6 8 7

*/

internal class GraphTest {

    private lateinit var graph: Graph

    @BeforeEach
    internal fun setUp() {
        graph = Graph(9)
        graph.addEdge(0, 1)
        graph.addEdge(1, 2)
        graph.addEdge(1, 3)
        graph.addEdge(2, 4)
        graph.addEdge(2, 3)
        graph.addEdge(3, 4)
        graph.addEdge(3, 5)
        graph.addEdge(5, 6)
        graph.addEdge(5, 7)
        graph.addEdge(6, 8)
    }

    @Test
    internal fun `스택을 이용한 DFS`() {
        graph.dfs()
        assertThat(graph.result).containsExactly(0, 1, 3, 5, 7, 6, 8, 4, 2)
    }

    @Test
    internal fun `재귀를 이용한 DFS`() {
        graph.dfsR()
        assertThat(graph.result).containsExactly(0, 1, 2, 4, 3, 5, 6, 8, 7)
    }
}