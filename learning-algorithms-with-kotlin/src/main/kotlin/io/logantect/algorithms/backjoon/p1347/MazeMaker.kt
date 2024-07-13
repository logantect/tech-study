package io.logantect.algorithms.backjoon.p1347

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    if (n > 50) {
        return
    }
    val commands = readLine()
    println(MazeMaker.solution(commands))
}

object MazeMaker {
    fun solution(message: String?): String {
        if (message == null) return ""

        var x = 0
        var y = 0
        // 남(S), 동(E), 북(N), 서(W) 순서로 방향 설정
        val directions = listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))
        var dirIndex = 0  // 초기 방향을 남쪽(S)로 설정
        val path = mutableListOf(Pair(x, y))

        message.forEach { command ->
            when (command) {
                'F' -> {
                    x += directions[dirIndex].first
                    y += directions[dirIndex].second
                    path.add(Pair(x, y))
                }
                'L' -> dirIndex = (dirIndex + 1) % 4  // 왼쪽 회전은 인덱스를 1 증가
                'R' -> dirIndex = (dirIndex + 3) % 4  // 오른쪽 회전은 인덱스를 3 증가 (역방향 회전)
            }
        }

        // 미로 범위 계산
        val minX = path.minOf { it.first }
        val maxX = path.maxOf { it.first }
        val minY = path.minOf { it.second }
        val maxY = path.maxOf { it.second }

        // 미로 그리기
        val maze = Array(maxY - minY + 1) { CharArray(maxX - minX + 1) { '#' } }
        path.forEach { (px, py) ->
            maze[py - minY][px - minX] = '.'
        }
        return maze.joinToString("\n") { it.joinToString("") }
    }
}
