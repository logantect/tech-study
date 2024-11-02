package io.logantect.algorithms.backjoon.p11866

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val stringTokenizer = StringTokenizer(firstLine)
    val n = stringTokenizer.nextToken().toInt()
    val k = stringTokenizer.nextToken().toInt()

    val result = JosephusProblem.solution(n, k)
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write(result)
    }
}

object JosephusProblem {
    fun solution(n: Int, k: Int): String {
        val list = MutableList(n) { it + 1 }
        var removeIndex = k - 1
        val result = StringBuilder("<")

        while (list.isNotEmpty()) {
            if (removeIndex >= list.size) {
                removeIndex %= list.size
            }
            result.append(list.removeAt(removeIndex))
            if (list.isNotEmpty()) {
                result.append(", ")
            }
            removeIndex += k - 1
        }
        result.append(">")
        return result.toString()
    }
}
