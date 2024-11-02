package io.logantect.algorithms.backjoon.p1436

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class MovieDirectorShomTest {

    private val movieDirectorShom: MovieDirectorShom = MovieDirectorShom()

    @Test
    fun testFirstNumber() {
        assertEquals(666, movieDirectorShom.findMovieNumber(1))
    }

    @Test
    fun testSecondNumber() {
        assertEquals(1666, movieDirectorShom.findMovieNumber(2))
    }

    @Test
    fun testThirdNumber() {
        assertEquals(2666, movieDirectorShom.findMovieNumber(3))
    }

    @Test
    fun testSixthNumber() {
        assertEquals(5666, movieDirectorShom.findMovieNumber(6))
    }

    @Test
    fun testOneHundredEightySeventhNumber() {
        assertEquals(66666, movieDirectorShom.findMovieNumber(187))
    }

    @Test
    fun testFiveHundredthNumber() {
        assertEquals(166699, movieDirectorShom.findMovieNumber(500))
    }

}