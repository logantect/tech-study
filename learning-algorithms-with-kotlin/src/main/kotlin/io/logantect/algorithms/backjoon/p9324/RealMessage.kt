package io.logantect.algorithms.backjoon.p9324

fun main() = with(System.`in`.bufferedReader()) {
    val numberOfMessages = readLine().toInt()
    val messages = mutableListOf<String>()

    repeat(numberOfMessages) {
        val message = readLine()
        messages.add(message)
    }
    RealMessage.solution(messages)
}


object RealMessage {
    fun solution(messages: List<String>) {
        messages.forEach { message ->
            if (isRealMessage(message)) {
                println("OK")
            } else {
                println("FAKE")
            }
        }
    }

    private fun isRealMessage(message: String): Boolean {
        val frequency = IntArray(26) { 0 }
        var index = 0

        while (index < message.length) {
            val char = message[index]
            val charIndex = char - 'A'
            frequency[charIndex]++

            if (frequency[charIndex] % 3 == 0) {
                if (index == message.length - 1 || message[index + 1] != char) {
                    return false
                } else {
                    index++
                }
            }
            index++
        }
        return true
    }
}