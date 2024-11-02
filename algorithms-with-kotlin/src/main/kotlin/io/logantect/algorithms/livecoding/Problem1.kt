package io.logantect.algorithms.livecoding

fun main(args: Array<String>) {
    Problem1.solutionWithLog()
}

object Problem1 {
    fun solution() {
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

    fun solutionWithLog() {
        val C = 259 // 트럭의 최대 적재량
        val weights = arrayOf(81, 58, 42, 33, 61) // 각 택배 박스의 무게
        val N = weights.size // 박스의 개수

        // DP 배열: dp[i]는 i 무게일 때 트럭에 실을 수 있는 최대 무게
        val dp = IntArray(C + 1)

        // 초기 상태 출력
        println("초기 DP 상태: ${dp.joinToString()}")

        for (i in 0 until N) {
            println("\n택배 박스 무게: ${weights[i]} 고려 중")

            for (j in C downTo weights[i]) {
                val oldValue = dp[j]
                val newValue = dp[j - weights[i]] + weights[i]

                // 상태 갱신
                dp[j] = maxOf(dp[j], newValue)

                // 갱신 로그 출력
                if (dp[j] != oldValue) {
                    println("dp[$j] 변경: $oldValue -> ${dp[j]} (dp[${j - weights[i]}] + ${weights[i]})")
                }
            }

            // 루프마다 DP 상태 출력
            println("현재 DP 상태: ${dp.joinToString()}")
        }

        // 결과 출력: dp[C]는 트럭의 최대 적재량에서 실을 수 있는 최대 무게
        println("\n박기사가 트럭에 실을 수 있는 가장 무거운 무게: ${dp[C]}")
    }
}