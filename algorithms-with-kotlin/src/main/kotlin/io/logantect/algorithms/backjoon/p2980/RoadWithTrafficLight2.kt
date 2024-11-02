package io.logantect.algorithms.backjoon.p2980

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val stringTokenizer = StringTokenizer(firstLine)
    val n = stringTokenizer.nextToken().toInt()
    val l = stringTokenizer.nextToken().toInt()
    val signals = mutableListOf<Triple<Int, Int, Int>>()

    repeat(n) {
        val tokenizer = StringTokenizer(readLine())
        val d = tokenizer.nextToken().toInt()
        val r = tokenizer.nextToken().toInt()
        val g = tokenizer.nextToken().toInt()
        signals.add(Triple(d, r, g))
    }

    val result = RoadWithTrafficLight2.calculateTravelTime(l, signals)
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("$result\n") // 잘못된 이스케이프 문자를 제거
    }
}

object RoadWithTrafficLight2 {
    fun calculateTravelTime(l: Int, signals: List<Triple<Int, Int, Int>>): Int {
        var currentTime = 0
        var currentPosition = 0

        for ((d, r, g) in signals) {
            // 신호등 위치로 이동
            currentTime += (d - currentPosition)
            currentPosition = d

            val cycleTime = r + g
            val timeInCycle = currentTime % cycleTime

            // 빨간 불일 경우 대기
            if (timeInCycle < r) {
                currentTime += (r - timeInCycle)
            }
        }

        // 도로 끝까지 이동
        currentTime += (l - currentPosition)
        return currentTime
    }
}