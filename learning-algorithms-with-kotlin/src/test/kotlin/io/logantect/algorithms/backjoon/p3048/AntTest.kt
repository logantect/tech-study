package io.logantect.algorithms.backjoon.p3048

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class AntTest {

    @Test
    fun solution1() {
        val output = Ant.solution(3, 3, "ABC", "DEF", 0)
        assertEquals("CBADEF", output)
    }

    @Test
    fun solution2() {
        val output = Ant.solution(3, 3, "ABC", "DEF", 2)
        assertEquals("CDBEAF", output)
    }

    @Test
    fun solution3() {
        val output = Ant.solution(3, 4, "JLA", "CRUO", 3)
        assertEquals("CARLUJO", output)
    }
}