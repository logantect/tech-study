package io.logantect.algorithms.backjoon.p30

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class ThirtyTest {

    @Test
    fun testFirstNumber() {
        assertEquals(30, Thirty.solution("30"))
    }

    @Test
    fun testSecondNumber() {
        assertEquals(210, Thirty.solution("102"))
    }

    @Test
    fun testThirdNumber() {
        assertEquals(-1, Thirty.solution("2931"))
    }

    @Test
    fun testSixthNumber() {
        assertEquals(88755420, Thirty.solution("80875542"))
    }
}