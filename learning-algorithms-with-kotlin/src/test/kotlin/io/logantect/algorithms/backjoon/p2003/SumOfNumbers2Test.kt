package io.logantect.algorithms.backjoon.p2003

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class SumOfNumbers2Test {

    @Test
    fun solution() {
        val solution = SumOfNumbers2.solution(4, 2, intArrayOf(1, 1, 1, 1))
        println(solution)
    }

    @Test
    fun solution2() {
        val solution = SumOfNumbers2.solution(10, 5, intArrayOf(1, 2, 3, 4, 2, 5, 3, 1, 1, 2))
        println(solution)
    }
}