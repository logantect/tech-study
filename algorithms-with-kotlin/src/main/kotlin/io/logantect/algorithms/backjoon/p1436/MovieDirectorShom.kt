package io.logantect.algorithms.backjoon.p1436

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    println(MovieDirectorShom().findMovieNumber(n))
}

class MovieDirectorShom {
    fun findMovieNumber(n: Int): Int {
        if (n > 10000) {
            throw IllegalArgumentException("Number is too big")
        }

        var movieNumber = 665
        var count = 0

        while (count < n) {
            movieNumber++
            if (movieNumber.toString().contains("666")) {
                count++
            }
        }
        return movieNumber
    }
}