package io.logantect.algorithms.arrays

import io.logantect.algorithms.MeasureTimeExtension
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MeasureTimeExtension::class)
class TwoSumTest {

    @Test
    fun twoSumBruteForceTest() {
        val result = BruteForceTwoSum().twoSum(intArrayOf(2, 6, 11, 15), 8)
        assertArrayEquals(intArrayOf(0, 1), result)
    }
}