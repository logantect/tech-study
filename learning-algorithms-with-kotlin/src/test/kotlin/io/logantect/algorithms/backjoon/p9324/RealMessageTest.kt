package io.logantect.algorithms.backjoon.p9324

import io.logantect.algorithms.backjoon.p6550.Substring
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class RealMessageTest {

    @Test
    fun solution() {
        val input = listOf(
            "BAPC",
            "AABA",
            "ABCABCBBAAACC"
        )

        val expectedOutput = listOf(
            "OK",
            "FAKE",
            "OK"
        ).joinToString("\n") + "\n"

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        RealMessage.solution(input)
        assertEquals(expectedOutput, outputStream.toString())
    }
}