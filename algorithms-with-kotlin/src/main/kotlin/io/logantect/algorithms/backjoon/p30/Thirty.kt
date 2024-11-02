package io.logantect.algorithms.backjoon.p30

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().toString()
    println(Thirty.solution(input))
}

object Thirty {
    fun solution(input: String): String {
        val digits = input.toCharArray()
        var zeroContained = false
        for (digit in digits) {
            if (digit == '0') {
                zeroContained = true
            }
        }

        if (!zeroContained) {
            return "-1"
        }

        val sum = digits.sumOf { it.code }
        if (sum % 3 != 0) {
            return "-1"
        }

        digits.sortDescending()
        return digits.joinToString("")
    }
}