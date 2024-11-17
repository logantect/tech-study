package io.logantect.algorithms.backjoon.p2644

import io.logantect.algorithms.backjoon.p2217.Rope
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stringTokenizer = StringTokenizer(readLine())

    val start = stringTokenizer.nextToken().toInt()
    val target = stringTokenizer.nextToken().toInt()
    val m = readLine().toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val edgeTokens = StringTokenizer(readLine())
        val x = edgeTokens.nextToken().toInt()
        val y = edgeTokens.nextToken().toInt()
        graph[x].add(y)
        graph[y].add(x)
    }

    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("${calculateKinship(graph, start, target)}\n")
    }
}

fun calculateKinship(graph: Array<MutableList<Int>>, start: Int, target: Int): Int {
    val visited = BooleanArray(graph.size) { false }
    val queue: Queue<Pair<Int, Int>> = LinkedList() // Pair(현재 노드, 촌수)

    queue.add(Pair(start, 0))
    visited[start] = true

    while (queue.isNotEmpty()) {
        val (current, kinship) = queue.poll()

        if (current == target) return kinship

        for (neighbor in graph[current]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                queue.add(Pair(neighbor, kinship + 1))
            }
        }
    }
    return -1 // 목표 인물과의 관계가 없는 경우
}
