package io.logantect.algorithms.backjoon.p2980

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class RoadWithTrafficLight2Test {

    @Test
    fun testExample1() {
        val totalDistance = 10
        val trafficLights = mapOf(
            3 to (5 to 5),
            5 to (2 to 2)
        )
        val expected = 12
        assertEquals(expected, RoadWithTrafficLight.solution(totalDistance, trafficLights))
    }

    @Test
    fun testExample2() {
        val totalDistance = 30
        val trafficLights = mapOf(
            7 to (13 to 5),
            14 to (4 to 4),
            15 to (3 to 10),
            25 to (1 to 1)
        )
        val expected = 36
        assertEquals(expected, RoadWithTrafficLight.solution(totalDistance, trafficLights))
    }

}