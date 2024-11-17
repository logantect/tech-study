package io.logantect.algorithms.backjoon.p2823

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun test() {
    val readLine = readLine()
}

fun main() = with(System.`in`.bufferedReader()) {
    val tokenizer = StringTokenizer(readLine())
    val rows = tokenizer.nextToken().toInt()
    val cols = tokenizer.nextToken().toInt()

    val grid = Array(rows) { readLine().toCharArray() }
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("${checkUTurnHate(grid, rows, cols)}\n")
    }
}

fun checkUTurnHate(grid: Array<CharArray>, rows: Int, cols: Int): Int {
    val directions = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == '.') {
                var openPaths = 0

                for ((rowOffset, colOffset) in directions) {
                    val newRow = r + rowOffset
                    val newCol = c + colOffset
                    if (newRow in 0 until rows && newCol in 0 until cols && grid[newRow][newCol] == '.') {
                        openPaths++
                    }
                }

                if (openPaths <= 1) return 1
            }
        }
    }
    return 0
}
