package io.logantect.algorithms.backjoon.p1931

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val meetings = Array(n) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        start to end
    }

    // 종료 시간을 기준으로 정렬하되, 종료 시간이 같으면 시작 시간 기준으로 정렬
    meetings.sortWith(compareBy({ it.second }, { it.first }))

    var count = 0
    var lastEndTime = 0

    for ((start, end) in meetings) {
        if (start >= lastEndTime) {
            count++
            lastEndTime = end
        }
    }

    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("$count\n")
    }
}
