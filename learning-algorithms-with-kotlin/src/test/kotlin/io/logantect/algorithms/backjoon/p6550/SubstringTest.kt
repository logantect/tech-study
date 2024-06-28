package io.logantect.algorithms.backjoon.p6550

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class SubstringTest {

    @Test
    fun solution() {
        val input = listOf(
            "sequence subsequence",
            "person compression",
            "VERDI vivaVittorioEmanueleReDiItalia",
            "caseDoesMatter CaseDoesMatter"
        )

        val expectedOutput = listOf(
            "Yes",
            "No",
            "Yes",
            "No"
        ).joinToString("\n") + "\n"

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        Substring.solution(input)

        assertEquals(expectedOutput, outputStream.toString())
    }
}