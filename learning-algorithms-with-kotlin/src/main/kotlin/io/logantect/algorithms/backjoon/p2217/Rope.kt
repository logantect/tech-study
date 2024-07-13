package io.logantect.algorithms.backjoon.p2217

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ropes = IntArray(n) { readLine().toInt() }
    println(Rope.solution(ropes))
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