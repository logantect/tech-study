package io.logantect.algorithms.backjoon.p3048

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val stringTokenizer = StringTokenizer(firstLine)
    val n1 = stringTokenizer.nextToken().toInt()
    val n2 = stringTokenizer.nextToken().toInt()
    val output = Ant.solution(
        n1 = n1,
        n2 = n2,
        inputGroup1 = readLine(),
        inputGroup2 = readLine(),
        time = readLine().toInt()
    )

    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("$output\n")
    }
}

object Ant {
    fun solution(
        n1: Int,
        n2: Int,
        inputGroup1: String,
        inputGroup2: String,
        time: Int,
    ): String {
        val totalLength = n1 + n2
        val ants = CharArray(totalLength)

        for (i in 0 until n1) {
            ants[i] = inputGroup1[n1 - 1 - i]
        }
        for (i in 0 until n2) {
            ants[n1 + i] = inputGroup2[i]
        }

        val group1Set = inputGroup1.toSet()
        val group2Set = inputGroup2.toSet()

        repeat(time) {
            var i = 0
            while (i < totalLength - 1) {
                if (ants[i] in group1Set && ants[i + 1] in group2Set) {
                    val temp = ants[i]
                    ants[i] = ants[i + 1]
                    ants[i + 1] = temp
                    i++
                }
                i++
            }
        }
        return ants.joinToString("")
    }
}