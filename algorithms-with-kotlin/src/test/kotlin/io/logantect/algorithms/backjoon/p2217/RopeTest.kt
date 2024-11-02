package io.logantect.algorithms.backjoon.p2217

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class RopeTest {

    @Test
    fun testSolution() {
        val testCases = listOf(
            Pair(intArrayOf(10, 15), 20),
            Pair(intArrayOf(10, 15, 20), 30),
            Pair(intArrayOf(5, 5, 5, 5), 20),
            Pair(intArrayOf(10), 10),
            Pair(intArrayOf(10, 20, 30, 40), 60),
            Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 30)
        )

        for ((input, expected) in testCases) {
            assertEquals(expected, Rope.solution(input))
        }
    }
}