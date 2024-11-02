package io.logantect.algorithms.backjoon.p4949

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WorldInBalanceTest {

    @ParameterizedTest
    @CsvSource(
        "So when I die (the [first] I will see in (heaven) is a score list)., true",
        "[ first in ] ( first out )., true",
        "Half Moon tonight (At least it is better than no Moon at all]., false",
        "A rope may form )( a trail in a maze., false",
        "Help( I[m being held prisoner in a fortune cookie factory)]., false",
        "([ (([( [ ] ) ( ) (( ))] )) ])., true",
        "., true"
    )
    fun testExampleCases(input: String, expected: Boolean) {
        assertEquals(expected, WorldInBalance.solution(input))
    }
}