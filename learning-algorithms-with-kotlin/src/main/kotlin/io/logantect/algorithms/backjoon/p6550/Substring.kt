package io.logantect.algorithms.backjoon.p6550

import java.util.StringTokenizer

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
            val stringTokenizer = StringTokenizer(it)
            val s = stringTokenizer.nextToken()
            val t = stringTokenizer.nextToken()
            var sIndex = 0

            for (i in t.indices) {
                if (sIndex < s.length && s[sIndex] == t[i]) {
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