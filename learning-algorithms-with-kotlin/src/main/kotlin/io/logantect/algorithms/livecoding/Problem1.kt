package io.logantect.algorithms.livecoding

fun main(args: Array<String>) {
    val C = 259 // 트럭의 최대 적재량
    val weights = arrayOf(81, 58, 42, 33, 61) // 각 택배 박스의 무게
    val N = weights.size // 박스의 개수

    // DP 배열: dp[i]는 i 무게일 때 트럭에 실을 수 있는 최대 무게
    val dp = IntArray(C + 1)

    for (i in 0 until N) {
        for (j in C downTo weights[i]) {
            dp[j] = maxOf(dp[j], dp[j - weights[i]] + weights[i])
        }
    }

    // 결과 출력: dp[C]는 트럭의 최대 적재량에서 실을 수 있는 최대 무게
    println("박기사가 트럭에 실을 수 있는 가장 무거운 무게: ${dp[C]}")
}

object Problem1 {
    fun solution() {
        val C = 259 // 최대 무게 제한
        val weights = arrayOf(81, 58, 42, 33, 61)

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
        println("최대 적립된 무게: $currentWeight")
    }

    fun solution2() {
        val C = 259 // 최대 무게 제한
        val weights = arrayOf(81, 58, 42, 33, 61)

        for (weight in weights) {

        }

    }
}