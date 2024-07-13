package io.logantect.algorithms.backjoon.p1347

import kotlin.test.Test
import org.junit.jupiter.api.Assertions.*

class MazeMakerTest {

    @Test
    fun testExample1() {
        val n = 5
        val commands = "RRFRF"
        val expected = """
            ..
            .#
        """.trimIndent()
        assertEquals(expected, MazeMaker.solution(commands))
    }

    @Test
    fun testExample2() {
        val n = 6
        val commands = "LFFRFF"
        val expected = """
            ...
            ##.
            ##.
        """.trimIndent()
        assertEquals(expected, MazeMaker.solution(commands))
    }

    @Test
    fun testExample3() {
        val n = 14
        val commands = "LFLFRRFLFRRFLF"
        val expected = """
            #.#
            ...
            #.#
        """.trimIndent()
        assertEquals(expected, MazeMaker.solution(commands))
    }

    @Test
    fun testExample4() {
        val n = 19
        val commands = "FLFRFFRFFFRFFRFLFLL"
        val expected = """
            #..#
            ....
            .##.
            ....
        """.trimIndent()
        assertEquals(expected, MazeMaker.solution(commands))
    }

    @Test
    fun testExample5() {
        val n = 31
        val commands = "FRFFFFFFLLFRFFFFFLLFRFFFFLFFLFF"
        val expected = """
            ######.
            .......
            #.#####
            #.#...#
            #.###.#
            #.....#
            #.#####
        """.trimIndent()
        assertEquals(expected, MazeMaker.solution(commands))
    }
}