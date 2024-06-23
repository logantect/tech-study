package io.logantect.algorithms.backjoon.p2635

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class ContinueNumberTest {

    @Test
    fun testSolutionWith100() {
        val result = ContinueNumber.solution(100)
        assertEquals(8, result.size)
        assertEquals(listOf(100, 62, 38, 24, 14, 10, 4, 6), result)
    }

    @Test
    fun testSolutionWith7() {
        val result = ContinueNumber.solution(7)
        assertEquals(5, result.size)
        assertEquals(listOf(7, 4, 3, 1, 2), result)
    }

    @Test
    fun testSolutionWith10() {
        val result = ContinueNumber.solution(10)
        assertEquals(7, result.size)
        assertEquals(listOf(10, 6, 4, 2, 2, 0, 2), result)
    }
}