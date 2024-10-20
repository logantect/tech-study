package io.logantect.algorithms.backjoon.p1260

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val stringTokenizer = StringTokenizer(firstLine)
    val n = stringTokenizer.nextToken().toInt()  // 정점 개수
    val m = stringTokenizer.nextToken().toInt()  // 간선 개수
    val start = stringTokenizer.nextToken().toInt()  // 시작 정점

    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val edge = readLine()
        val st = StringTokenizer(edge)
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        graph[u].add(v)
        graph[v].add(u)
    }

    for (i in 1..n) {
        graph[i].sort()
    }

    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        DFSAndBFS.solution(n, start, graph, writer)
        writer.flush()
    }
}

object DFSAndBFS {
    fun solution(n: Int, start: Int, graph: Array<MutableList<Int>>, writer: BufferedWriter) {
        // DFS 수행 결과 출력
        val visitedDFS = BooleanArray(n + 1)
        dfs(graph, start, visitedDFS, writer)
        writer.newLine()

        // BFS 수행 결과 출력
        val visitedBFS = BooleanArray(n + 1)
        bfs(graph, start, visitedBFS, writer)
    }

    // 깊이 우선 탐색 (DFS)
    private fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray, writer: BufferedWriter) {
        visited[v] = true
        writer.write("$v ")

        for (next in graph[v]) {
            if (!visited[next]) {
                dfs(graph, next, visited, writer)
            }
        }
    }

    // 너비 우선 탐색 (BFS)
    private fun bfs(graph: Array<MutableList<Int>>, start: Int, visited: BooleanArray, writer: BufferedWriter) {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val v = queue.poll()
            writer.write("$v ")

            for (next in graph[v]) {
                if (!visited[next]) {
                    visited[next] = true
                    queue.add(next)
                }
            }
        }
    }
}