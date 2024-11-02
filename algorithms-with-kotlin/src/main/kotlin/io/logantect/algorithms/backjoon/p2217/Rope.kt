package io.logantect.algorithms.backjoon.p2217

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ropes = IntArray(n) { readLine().toInt() }
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("${Rope.solution(ropes)}\n")
    }
}

object Rope {
    fun solution(ropes: IntArray): Int {
        ropes.sort()
        var maxWeight = 0
        for (i in ropes.indices) {
            val weight = ropes[i] * (ropes.size - i)
            if (weight > maxWeight) {
                maxWeight = weight
            }
        }
        return maxWeight
    }
}