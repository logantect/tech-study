package io.logantect.algorithms.backjoon.p2852

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val messages = mutableListOf<String>()

    repeat(n) {
        messages.add(readLine())
    }

    NBA.solution(messages)
}

object NBA {
    fun solution(list: List<String>) {
        val gameTimeSecond = 48 * 60
        val result = mutableMapOf<Int, String>()

        list.forEach {
            val tokenizer = StringTokenizer(it)
            val id = tokenizer.nextToken()
            val time = tokenizer.nextToken()
            val timeTokenizer = StringTokenizer(time, ":")
            val minutes = timeTokenizer.nextToken().toInt()
            val seconds = timeTokenizer.nextToken().toInt()
            val totalSeconds = minutes * 60 + seconds
            result[totalSeconds] = id
        }

        var a = 0
        var b = 0
        var aWinTime = 0
        var bWinTime = 0

        for (i in 0 until gameTimeSecond) {
            result[i]?.let { id ->
                when (id) {
                    "1" -> a += 1
                    "2" -> b += 1
                }
            }

            if (a > b) {
                aWinTime += 1
            } else if (b > a) {
                bWinTime += 1
            }
        }

        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            writer.write("${secondToFormat(aWinTime)}\n")
            writer.write("${secondToFormat(bWinTime)}\n")
        }
    }

    private fun secondToFormat(totalSeconds: Int): String {
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        val timeFormatted = StringBuilder()
        if (minutes < 10) timeFormatted.append('0')
        timeFormatted.append(minutes)
        timeFormatted.append(':')
        if (seconds < 10) timeFormatted.append('0')
        timeFormatted.append(seconds)
        return timeFormatted.toString()
    }
}