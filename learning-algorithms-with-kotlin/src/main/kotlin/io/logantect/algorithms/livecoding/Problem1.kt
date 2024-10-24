package io.logantect.algorithms.livecoding

fun main(args: Array<String>) {
    Problem1.solution()
}

object Problem1 {
    fun solution() {
        val C = 259 // 최대 무게 제한
        val weights = arrayOf(81, 58, 42, 33, 61)
        var result = 0 // 적립된 무게

        // 내림차순으로 정렬
        val sortedWeights = weights.sortedArrayDescending()

        var currentWeight = 0
        sortedWeights.forEach { weight ->
            // 최대 무게를 넘지 않는다면 적립
            if (currentWeight + weight <= C) {
                currentWeight += weight
            }
        }

        // 결과 출력
        result = currentWeight
        println("최대 적립된 무게: $result")
    }
}