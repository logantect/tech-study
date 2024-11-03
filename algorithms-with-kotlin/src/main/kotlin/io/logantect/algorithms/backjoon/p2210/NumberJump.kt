package io.logantect.algorithms.backjoon.p2210

import java.util.HashSet

val dx = arrayOf(0, 1, 0, -1) // 오른쪽, 아래, 왼쪽, 위
val dy = arrayOf(1, 0, -1, 0)
val uniqueNumbers = HashSet<String>()

fun main() = with(System.`in`.bufferedReader()) {
    val grid = Array(5) { readLine().split(" ").toTypedArray() }

    for (i in 0 until 5) {
        for (j in 0 until 5) {
            dfs(grid, i, j, 0, "")
        }
    }

    println(uniqueNumbers.size)
}

fun dfs(grid: Array<Array<String>>, x: Int, y: Int, depth: Int, current: String) {
    if (depth == 6) {
        uniqueNumbers.add(current)
        return
    }

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx in 0 until 5 && ny in 0 until 5) {
            dfs(grid, nx, ny, depth + 1, current + grid[x][y])
        }
    }
}
