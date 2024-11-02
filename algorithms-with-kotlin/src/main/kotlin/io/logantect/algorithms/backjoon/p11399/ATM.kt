package io.logantect.algorithms.backjoon.p11399

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val tokenizer = StringTokenizer(readLine())
    val times = IntArray(n) { tokenizer.nextToken().toInt() }

    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("${ATM.solution(times)}\n")
    }
}

object ATM {
    fun solution(times: IntArray): Int {
        times.sort()

        var totalWaitTime = 0
        var currentWaitTime = 0

        for (time in times) {
            currentWaitTime += time
            totalWaitTime += time
        }

        return totalWaitTime
    }
}
