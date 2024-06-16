package io.logantect.algorithms._inbox

import io.logantect.algorithms.backjoon.p1331.KnightTourSolution01
import kotlin.test.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class KnightTourTest {
    @ParameterizedTest
    @MethodSource("tourCases")
    fun knightTourSolution01(tourCase: Pair<List<String>, String>) {
        val knightTour = KnightTourSolution01()
        assertEquals(knightTour.solution(tourCase.first), tourCase.second)
    }

    companion object {
        @JvmStatic
        fun tourCases() = listOf(
            // 예제 입력 1
            Pair(
                listOf("A1", "B3", "A5", "C6", "E5", "F3", "D2", "F1", "E3", "F5", "D4", "B5", "A3", "B1", "C3", "A2", "C1", "E2", "F4", "E6", "C5", "A6", "B4", "D5", "F6", "E4", "D6", "C4", "B6", "A4", "B2", "D1", "F2", "D3", "E1", "C2"),
                "Valid"
            ),
            // 예제 입력 2
            Pair(
                listOf("A1", "C2", "E3", "F5", "D4", "B3", "A1", "C2", "E3", "F5", "D4", "B3", "A1", "C2", "E3", "F5", "D4", "B3", "A1", "C2", "E3", "F5", "D4", "B3", "A1", "C2", "E3", "F5", "D4", "B3", "A1", "C2", "E3", "F5", "D4", "B3"),
                "Invalid"
            ),
            // 예제 입력 3
            Pair(
                listOf("D4", "F5", "D6", "B5", "A3", "B1", "D2", "F1", "E3", "D1", "F2", "E4", "F6", "D5", "B6", "A4", "B2", "C4", "A5", "C6", "E5", "F3", "E1", "C2", "A1", "B3", "C5", "E6", "F4", "E2", "C3", "A2", "C1", "D3", "B4", "A6"),
                "Invalid"
            ),
            // 예제 입력 4
            Pair(
                listOf("D4", "F5", "D6", "B5", "A3", "B1", "D2", "F1", "E3", "D1", "F2", "E4", "F6", "D5", "B6", "A4", "B2", "C4", "A5", "C6", "E5", "F3", "E1", "C2", "A1", "B3", "C5", "A6", "B4", "A2", "C3", "E2", "C1", "D3", "F4", "E6"),
                "Valid"
            ),
            // 예제 입력 5
            Pair(
                listOf("C5", "D3", "F2", "D1", "B2", "A4", "B6", "D5", "C3", "E4", "F6", "B3", "A1", "C2", "E1", "F3", "E5", "C6", "A5", "C4", "A3", "B1", "D2", "F1", "E3", "F5", "D6", "B5", "D4", "E6", "F4", "E2", "C1", "A2", "B4", "A6"),
                "Invalid"
            )
        )
    }
}