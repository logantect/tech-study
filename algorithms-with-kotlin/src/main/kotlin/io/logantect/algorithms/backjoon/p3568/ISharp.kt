package io.logantect.algorithms.backjoon.p3568

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val output = ISharp.solution(firstLine)
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        output.forEach {
            writer.write("$it\n")
        }
    }
}

object ISharp {
    fun solution(variableDeclaration: String): List<String> {
        val variablesTokenizer = StringTokenizer(variableDeclaration, " ,;")
        val type = variablesTokenizer.nextToken()
        val results = mutableListOf<String>()
        while (variablesTokenizer.hasMoreTokens()) {
            val variableTypeBuilder = StringBuilder(type)
            val variablePart = variablesTokenizer.nextToken()
            val variable = variablePart.filter { it.isLetterOrDigit() }
            for (i in variablePart.indices.reversed()) {
                when (variablePart[i]) {
                    '&' -> variableTypeBuilder.append('&')
                    '[' -> variableTypeBuilder.append("[]")
                    '*' -> variableTypeBuilder.append('*')
                }
            }
            results.add("$variableTypeBuilder $variable;")
        }
        return results.toList()
    }
}