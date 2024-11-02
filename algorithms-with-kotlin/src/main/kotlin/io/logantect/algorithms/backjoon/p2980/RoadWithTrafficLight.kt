package io.logantect.algorithms.backjoon.p2980

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val stringTokenizer = StringTokenizer(firstLine)
    val n = stringTokenizer.nextToken().toInt()
    val l = stringTokenizer.nextToken().toInt()

    val trafficLights = mutableMapOf<Int, Pair<Int, Int>>()
    repeat(n) {
        val tokenizer = StringTokenizer(readLine())
        val d = tokenizer.nextToken().toInt()
        val r = tokenizer.nextToken().toInt()
        val g = tokenizer.nextToken().toInt()
        trafficLights[d] = r to g
    }

    val travelTime = RoadWithTrafficLight.solution(l, trafficLights)
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("$travelTime\n")
    }
}

object RoadWithTrafficLight {
    fun solution(totalDistance: Int, trafficLights: Map<Int, Pair<Int, Int>>): Int {
        var travelTime = 0
        for (i in 0 until totalDistance) {
            trafficLights[i]?.let {
                val timeInCycle = travelTime % (it.first + it.second)
                if (timeInCycle < it.first) {
                    travelTime += (it.first - timeInCycle)
                }
            }
            travelTime++
        }
        return travelTime
    }
}