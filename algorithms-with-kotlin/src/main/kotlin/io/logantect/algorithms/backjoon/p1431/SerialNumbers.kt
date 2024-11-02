package io.logantect.algorithms.backjoon.p1431

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Arrays

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val serialNumbers = Array<String>(n) {
        readLine()
    }
    val result = SerialNumbers.solution(serialNumbers)
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("$result\n")
    }
}

object SerialNumbers {
    /*
        배열을 직접 정렬하고 출력에 리스트를 사용하지 않아서 더 빠르다.
    */
    fun solution(serialNumbers: Array<String>): String {
        Arrays.sort(serialNumbers, compareBy<String> {
            it.length
        }.thenBy {
            it.sumOf { char -> if (char.isDigit()) char - '0' else 0 }
        }.thenBy {
            it
        })

        val result = StringBuilder(2550)
        for (serial in serialNumbers) {
            result.append(serial).append("\n")
        }
        return result.toString()
    }

    /*
        첫 번째 풀이 방법
        리스트를 응답하고 sortedWith에서 리스트를 반환하니까 메모리를 더 많이쓰고 응답 출력이 느리다.
    */
    fun solution1(serialNumbers: Array<String>): List<String> {
        return serialNumbers.sortedWith(
            compareBy<String> {
                it.length
            }.thenBy {
                it.sumOf { char -> if (char.isDigit()) char - '0' else 0 }
            }.thenBy {
                it
            }
        )
    }
}