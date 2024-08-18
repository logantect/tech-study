package io.logantect.algorithms.backjoon.p1431

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SerialNumbersTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun testSolution(serialNumbers: Array<String>, expected: List<String>) {
        val result = SerialNumbers.solution(serialNumbers)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun provideTestCases(): List<Array<Any>> {
            return listOf(
                arrayOf(
                    arrayOf("ABCD", "145C", "A", "A910", "Z321"),
                    listOf("A", "ABCD", "Z321", "145C", "A910")
                ),
                arrayOf(
                    arrayOf("Z19", "Z20"),
                    listOf("Z20", "Z19")
                ),
                arrayOf(
                    arrayOf(
                        "34H2BJS6N",
                        "PIM12MD7RCOLWW09",
                        "PYF1J14TF",
                        "FIPJOTEA5",
                    ),
                    listOf(
                        "FIPJOTEA5",
                        "PYF1J14TF",
                        "34H2BJS6N",
                        "PIM12MD7RCOLWW09",
                    )
                ),
                arrayOf(
                    arrayOf(
                        "ABCDE",
                        "BCDEF",
                        "ABCDA",
                        "BAAAA",
                        "ACAAA",
                    ),
                    listOf(
                        "ABCDA",
                        "ABCDE",
                        "ACAAA",
                        "BAAAA",
                        "BCDEF",
                    )
                )
            )
        }
    }
}