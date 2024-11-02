package io.logantect.algorithms.backjoon.p3085

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val board = Array(n) { readLine().toCharArray() }
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("${CandyGame.solution(n, board)}\n")
    }
}

object CandyGame {
    fun solution(n: Int, board: Array<CharArray>): Int {
        var maxCandy = 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                // 오른쪽과 교환
                if (j + 1 < n) {
                    board[i][j] = board[i][j + 1].also { board[i][j + 1] = board[i][j] }
                    maxCandy = maxOf(maxCandy, checkMaxCandies(board, n, i, j), checkMaxCandies(board, n, i, j + 1))
                    board[i][j] = board[i][j + 1].also { board[i][j + 1] = board[i][j] }  // 원상 복구
                }

                // 아래쪽과 교환
                if (i + 1 < n) {
                    board[i][j] = board[i + 1][j].also { board[i + 1][j] = board[i][j] }
                    maxCandy = maxOf(maxCandy, checkMaxCandies(board, n, i, j), checkMaxCandies(board, n, i + 1, j))
                    board[i][j] = board[i + 1][j].also { board[i + 1][j] = board[i][j] }  // 원상 복구
                }
            }
        }

        return maxCandy
    }

    private fun checkMaxCandies(board: Array<CharArray>, n: Int, i: Int, j: Int): Int {
        var maxCount = 0

        // 교환 행 검사
        var rowCount = 1
        for (x in 1 until n) {
            if (board[i][x] == board[i][x - 1]) {
                rowCount++
            } else {
                maxCount = maxOf(maxCount, rowCount)
                rowCount = 1
            }
        }
        maxCount = maxOf(maxCount, rowCount)

        // 교환 열 검사
        var colCount = 1
        for (y in 1 until n) {
            if (board[y][j] == board[y - 1][j]) {
                colCount++
            } else {
                maxCount = maxOf(maxCount, colCount)
                colCount = 1
            }
        }
        maxCount = maxOf(maxCount, colCount)

        return maxCount
    }
}