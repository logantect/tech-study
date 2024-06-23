## [백준 2635번: 수 이어가기](https://www.acmicpc.net/problem/1436)

### 1. 추상화
#### 문제 설명:
1. 첫 번째 수 n이 주어집니다.
2. 두 번째 수는 1부터 n까지의 양의 정수 중 하나를 선택합니다.
3. 세 번째 수부터는 앞의 두 수의 차를 계산하여 수열을 이어갑니다.
4. 음수가 나오면 수열을 종료합니다.
5. 가능한 가장 긴 수열을 찾습니다.

#### 목표:
1. 주어진 n과 가능한 모든 두 번째 수에 대해 가장 긴 수열을 찾아 그 길이와 수열을 반환합니다.
2. 시간 제한 2초, 메모리 제한 129MB.


### 2. 계산
#### 불변량(Invariant) 정의:
1. 수열의 각 숫자는 앞의 두 수의 차로 생성됩니다.
2. 음수가 나오면 수열이 종료됩니다.

#### 알고리즘 단계:
1. 첫 번째 수 n과 두 번째 수 secondNum을 초기화합니다.
2. n과 secondNum의 차이를 계산하여 수열을 생성합니다.
3. 음수가 나오기 전까지 수열을 계속 확장합니다.
4. 모든 가능한 secondNum에 대해 위 과정을 반복하여 가장 긴 수열을 찾습니다.

#### 코드 구현:
```kotlin
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val bestSequence = ContinueNumber.solution(n)
    println(bestSequence.size)
    println(bestSequence.joinToString(" "))
}

object ContinueNumber {
    fun solution(n: Int): List<Int> {
        var maxLength = 0 // 최장 수열의 길이를 저장
        var bestSequence = listOf<Int>() // 최장 수열을 저장

        // 가능한 모든 두 번째 수를 시도
        for (secondNum in 1..n) {
            // 현재 secondNum으로 수열 생성
            val sequence = generateSequence(n, secondNum)

            // 가장 긴 수열을 찾기 위해 비교
            if (sequence.size > maxLength) {
                maxLength = sequence.size
                bestSequence = sequence
            }
        }
        return bestSequence
    }

    // 수열을 생성하는 함수를 별도로 추출
    private fun generateSequence(first: Int, second: Int): List<Int> {
        val sequence = mutableListOf(first, second)
        while (true) {
            // 두 개의 초기 값 first와 second를 받아서, 수열을 생성합니다.
            val nextNum = sequence[sequence.size - 2] - sequence.last()
            if (nextNum < 0) break // 음수가 나오면 종료
            sequence.add(nextNum) // 수열에 추가
        }
        // 완성된 수열을 반환합니다.
        return sequence
    }
}
```

### 3. 해석
#### 1. **첫 번째 수와 두 번째 수 선택**:
1. 첫 번째 수는 문제에서 주어진 `100`입니다.
2. 두 번째 수는 `1`부터 `100`까지의 모든 정수 중 하나를 선택할 수 있습니다. 예를 들어, 두 번째 수를 `62`로 선택합니다.

#### 2. **수열 생성**:
1. 첫 번째 수와 두 번째 수를 사용하여 수열을 생성합니다.
2. 초기 수열은 `[100, 62]`입니다.
3. 세 번째 수는 `100 - 62 = 38`입니다. 수열은 `[100, 62, 38]`이 됩니다.
4. 네 번째 수는 `62 - 38 = 24`입니다. 수열은 `[100, 62, 38, 24]`이 됩니다.
5. 다섯 번째 수는 `38 - 24 = 14`입니다. 수열은 `[100, 62, 38, 24, 14]`이 됩니다.
6. 여섯 번째 수는 `24 - 14 = 10`입니다. 수열은 `[100, 62, 38, 24, 14, 10]`이 됩니다.
7. 일곱 번째 수는 `14 - 10 = 4`입니다. 수열은 `[100, 62, 38, 24, 14, 10, 4]`이 됩니다.
8. 여덟 번째 수는 `10 - 4 = 6`입니다. 수열은 `[100, 62, 38, 24, 14, 10, 4, 6]`이 됩니다.
9. 아홉 번째 수는 `4 - 6 = -2`입니다. 음수가 되므로 수열이 종료됩니다.

#### 3. **가장 긴 수열 찾기**:
1. 위의 과정에서 생성된 수열의 길이는 `8`입니다. 수열은 `[100, 62, 38, 24, 14, 10, 4, 6]`입니다.
2. 이러한 과정을 두 번째 수가 `1`부터 `100`까지의 모든 값에 대해 반복합니다.
3. 이 중 가장 긴 수열을 찾아 반환합니다.

#### 4. **결과**:
1. 두 번째 수가 `62`일 때, 가장 긴 수열 `[100, 62, 38, 24, 14, 10, 4, 6]`을 얻습니다.
2. 이 수열의 길이는 `8`입니다.
3. 따라서, `n = 100`일 때 가장 긴 수열의 길이는 `8`이며, 수열은 `[100, 62, 38, 24, 14, 10, 4, 6]`입니다.