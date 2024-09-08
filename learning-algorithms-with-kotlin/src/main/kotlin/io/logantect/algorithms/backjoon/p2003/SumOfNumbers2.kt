package io.logantect.algorithms.backjoon.p2003

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val stringTokenizer = StringTokenizer(firstLine)
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val stringTokenizer2 = StringTokenizer(readLine())
    val numbers = IntArray(n) { stringTokenizer2.nextToken().toInt() }

    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("${SumOfNumbers2.solution(n, m, numbers)}\n")
    }
}

object SumOfNumbers2 {
    fun solution(n: Int, m: Int, numbers: IntArray): Int {
        var count = 0
        var sum = 0
        var i = 0

        for (j in 0 until n) {
            sum += numbers[j]

            // sum이 m을 초과하면 i 포인터를 이동시켜서 합을 줄임
            while (sum > m) {
                sum -= numbers[i]
                i++
            }

            // sum이 m과 같으면 카운트 증가
            if (sum == m) {
                count++
            }
        }
        return count
    }

    fun solutionBruteForce(n: Int, m: Int, numbers: IntArray): Int {
        var count = 0
        for (i in 0 until n) {
            var sum = 0
            for (j in i until n) {
                sum += numbers[j]
                if (sum == m) {
                    count++
                    break
                } else if (sum > m) {
                    break
                }
            }
        }
        return count
    }
}