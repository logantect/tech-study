package io.logantect.algorithms.backjoon.p11047

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val stringTokenizer = StringTokenizer(firstLine)
    val n = stringTokenizer.nextToken().toInt()
    val k = stringTokenizer.nextToken().toInt()
    val coins = IntArray(n) { readLine().toInt() }

    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("${Coin0.solution(k, coins)}\n")
    }
}

object Coin0 {
    fun solution(k: Int, coins: IntArray): Int {
        var amount = k
        var count = 0

        for (coin in coins.reversed()) {
            if (coin <= amount) {
                count += amount / coin
                amount %= coin
            }
        }

        return count
    }
}