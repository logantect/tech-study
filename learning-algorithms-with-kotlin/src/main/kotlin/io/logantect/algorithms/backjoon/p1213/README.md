# [백준 9324번: 진짜 메시지](https://www.acmicpc.net/problem/9324)

## 1. 추상화
### 문제 설명:
1. 여러 개의 메시지가 주어진다.
2. 각 메시지에는 A부터 Z까지의 대문자만 포함되어 있다.
3. 진짜 메시지는 각 문자가 정확히 세 번 나타날 때 네 번째 문자가 동일해야 한다.
4. 모든 메시지에 대해 진짜 메시지인지 여부를 확인한다.
5. 시간 제한: 1초
6. 메모리 제한: 128MB

### 목표:
1. 각 메시지가 진짜 메시지인지 여부를 확인하여 `OK` 또는 `FAKE`를 출력한다.

## 2. 계산
### 불변량(Invariant) 정의:
1. 각 문자가 세 번 나타날 때 네 번째 문자가 동일해야 진짜 메시지이다.

### 알고리즘 단계:
1. 입력으로 여러 줄의 메시지를 받는다.
2. 각 메시지에 대해:
   - 각 문자의 빈도를 기록할 배열을 초기화한다.
   - 메시지를 한 문자씩 순회하며:
      - 해당 문자의 빈도를 증가시킨다.
      - 빈도가 3의 배수인 경우:
         - 다음 문자가 동일한지 확인한다.
         - 동일하지 않으면 `FAKE`를 출력하고, 메시지 처리를 중단한다.
   - 메시지의 모든 문자가 조건을 만족하면 `OK`를 출력한다.

### 시간 복잡도:
- 각 메시지를 한 번 순회하므로 시간 복잡도는 O(n)이다. 여기서 n은 메시지의 길이이다.
- 여러 메시지에 대해 수행할 때, 총 시간 복잡도는 O(m * n)이다. 여기서 m은 메시지의 수, n은 각 메시지의 평균 길이이다.

### 공간 복잡도:
- 각 문자의 빈도를 기록하기 위해 배열을 사용하므로 공간 복잡도는 O(1)이다. (고정된 크기의 배열 사용)

### 코드 구현:
```kotlin
fun main() = with(System.`in`.bufferedReader()) {
    val numberOfMessages = readLine().toInt()
    val messages = mutableListOf<String>()

    repeat(numberOfMessages) {
        val message = readLine()
        messages.add(message)
    }

    messages.forEach { message ->
        if (isRealMessage(message)) {
            println("OK")
        } else {
            println("FAKE")
        }
    }
}

fun isRealMessage(message: String): Boolean {
    val frequency = IntArray(26) { 0 }

    message.forEachIndexed { index, char ->
        val charIndex = char - 'A'
        frequency[charIndex]++

        if (frequency[charIndex] % 3 == 0) {
            if (index == message.length - 1 || message[index + 1] != char) {
                return false
            }
        }
    }

    return true
}
```

## 3. 해석

### 1. **첫 번째 문자와 빈도 배열 초기화**:

1. 첫 번째 메시지는 예제에서 주어진 `"BAPC"`이다.
2. 두 번째 메시지는 예제에서 주어진 `"AABA"`이다.
3. 세 번째 메시지는 예제에서 주어진 `"ABCABCBBAAACC"`이다.

### 2. **문자 빈도 확인**:

1. 각 메시지를 한 문자씩 순회하며 빈도를 계산한다.
2. 빈도가 3의 배수가 되는 경우, 다음 문자가 동일한지 확인한다.
3. 동일하지 않으면 `FAKE`로 판단하고 메시지 처리를 중단한다.

### 3. **진짜 메시지 여부 결정**:

1. 모든 조건을 만족하면 `OK`를 출력한다.
2. 하나라도 조건을 만족하지 않으면 `FAKE`를 출력한다.

### 4. **결과**:

1. 첫 번째 메시지 `"BAPC"`는 모든 조건을 만족하므로 결과는 `OK`이다.
2. 두 번째 메시지 `"AABA"`는 조건을 만족하지 않으므로 결과는 `FAKE`이다.
3. 세 번째 메시지 `"ABCABCBBAAACC"`는 모든 조건을 만족하므로 결과는 `OK`이다.

