package io.logantect.algorithms.backjoon.p4949

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()) {
    val output = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val line = readLine()
        if (line == ".") break

        if (WorldInBalance.solution2(line)) {
            output.write("yes\n")
        } else {
            output.write("no\n")
        }
    }

    output.flush()
    output.close()
}

object WorldInBalance {
    fun solution(input: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (char in input) {
            when (char) {
                '(', '[' -> stack.addFirst(char)
                ')' -> {
                    if (stack.isEmpty() || stack.first() != '(') return false
                    stack.removeFirst()
                }

                ']' -> {
                    if (stack.isEmpty() || stack.first() != '[') return false
                    stack.removeFirst()
                }
            }
        }

        return stack.isEmpty()
    }

    fun solution2(input: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (char in input) {
            when (char) {
                '(', '[' -> stack.addFirst(char)
                ')' -> {
                    val lastOpen = if (stack.isNotEmpty()) {
                        stack.removeFirst()
                    } else {
                        return false
                    }
                    if (lastOpen != '(') return false
                }

                ']' -> {
                    val lastOpen = if (stack.isNotEmpty()) {
                        stack.removeFirst()
                    } else {
                        return false
                    }
                    if (lastOpen != '[') return false
                }
            }
        }
        return stack.isEmpty()
    }
}