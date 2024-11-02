package io.logantect.algorithms.backjoon.p2635

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val bestSequence = ContinueNumber.solution(n)
    println(bestSequence.size)
    println(bestSequence.joinToString(" "))
}

object ContinueNumber {
    fun solution(n: Int): List<Int> {
        var maxLength = 0
        var bestSequence = listOf<Int>()

        // 가능한 모든 두 번째 수를 시도
        for (secondNum in 1..n) {
            val sequence = generateSequence(n, secondNum)

            // 가장 긴 수열을 찾기 위해 비교
            if (sequence.size > maxLength) {
                maxLength = sequence.size
                bestSequence = sequence
            }
        }
        return bestSequence
    }

    private fun generateSequence(first: Int, second: Int): List<Int> {
        val sequence = mutableListOf(first, second)
        while (sequence[sequence.size - 2] - sequence.last() >= 0) {
            sequence.add(sequence[sequence.size - 2] - sequence.last())
        }
        return sequence
    }
}
