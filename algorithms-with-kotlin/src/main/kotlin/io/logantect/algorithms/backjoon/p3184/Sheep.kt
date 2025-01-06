package io.logantect.algorithms.backjoon.p3184

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Position(val x: Int, val y: Int)

fun main() {
    val tokenizer = StringTokenizer(readln())
    val rows = tokenizer.nextToken().toInt()
    val cols = tokenizer.nextToken().toInt()

    val farm = Array(rows) { readln().toCharArray() }
    val visited = Array(rows) { BooleanArray(cols) }

    var totalSheep = 0
    var totalWolves = 0

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (!visited[i][j] && farm[i][j] != '#') {
                val (sheep, wolves) = bfs(i, j, rows, cols, farm, visited)
                if (sheep > wolves) totalSheep += sheep else totalWolves += wolves
            }
        }
    }

    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("$totalSheep $totalWolves\n")
    }
}

private fun bfs(
    startX: Int,
    startY: Int,
    rows: Int,
    cols: Int,
    farm: Array<CharArray>,
    visited: Array<BooleanArray>
): Pair<Int, Int> {
    val directions = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    val queue: Queue<Position> = LinkedList()
    queue.add(Position(startX, startY))
    visited[startX][startY] = true

    var sheep = 0
    var wolves = 0

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        when (farm[x][y]) {
            'o' -> sheep++
            'v' -> wolves++
        }
        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy
            if (nx in 0 until rows && ny in 0 until cols && farm[nx][ny] != '#' && !visited[nx][ny]) {
                visited[nx][ny] = true
                queue.add(Position(nx, ny))
            }
        }
    }
    return sheep to wolves
}

