package io.logantect.algorithms.backjoon.p6550

fun main() = with(System.`in`.bufferedReader()) {
    val readLines = mutableListOf<String>()
    while (true) {
        val line = readLine() ?: break
        readLines.add(line)
    }
    Substring.solution(readLines)
}

object Substring {
    fun solution(strList: List<String>) {
        strList.forEach {
            val (s, t) = it.split(" ")
            var sIndex = 0

            t.forEach { char ->
                if (sIndex < s.length && s[sIndex] == char) {
                    sIndex++
                }
            }

            if (sIndex == s.length) {
                println("Yes")
            } else {
                println("No")
            }
        }
    }
}