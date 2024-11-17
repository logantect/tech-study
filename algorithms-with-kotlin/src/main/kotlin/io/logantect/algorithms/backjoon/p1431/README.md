# [백준 1431번: 시리얼 번호](https://www.acmicpc.net/problem/1431)

## 문제

---

시리얼 번호는 알파벳 대문자(A-Z)와 숫자(0-9)로 이루어진다.

시리얼 번호 A가 시리얼 번호 B의 앞에 오는 경우는 다음과 같다.

1. A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
2. 만약 서로 길이가 같다면, 모든 자리의 숫자의 합이 작은 것이 먼저 온다.
3. 만약 1번, 2번 조건으로도 비교할 수 없으면, 사전 순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.

N개의 시리얼 번호를 정렬한 다음 출력하는 프로그램을 작성하시오.

### 입력

첫째 줄에 시리얼 번호의 개수 N이 주어진다. N은 50보다 작거나 같다. 둘째 줄부터 N개의 줄에 시리얼 번호가 하나씩 주어진다. 시리얼 번호의 길이는 최대 50이고, 알파벳 대문자와 숫자로만 이루어져 있다.

### 출력

첫째 줄부터 N개의 줄에 시리얼 번호를 주어진 조건대로 정렬하여 출력한다.

### 입력 예제:

```
5
ABCD
145C
A
A910
Z321

```

### 출력 예제:

```
A
ABCD
Z321
145C
A910

```

---

## 1. 추상화

### 문제 설명:

1. 주어진 시리얼 번호들을 특정한 조건에 따라 정렬해야 합니다.
2. 첫 번째 조건은 길이순 정렬입니다.
3. 두 번째 조건은 각 시리얼 번호에 포함된 숫자의 합으로 정렬하는 것입니다.
4. 세 번째 조건은 사전순으로 정렬하는 것입니다.

### 목표:

1. 주어진 시리얼 번호들을 조건에 따라 정렬하여 출력합니다.
2. 시간 제한 2초, 메모리 제한 128MB.

## 2. 계산

### 불변량(Invariant) 정의:

1. 정렬 기준이 세 가지 조건에 따라 정확하게 유지되어야 합니다.
2. 모든 시리얼 번호는 길이순으로, 길이가 같은 경우 숫자의 합으로, 이 둘로도 정렬이 안 될 경우 사전순으로 정렬됩니다.

### 알고리즘 단계:

1. **정렬 기준 정의**:
   - 시리얼 번호의 길이를 기준으로 오름차순 정렬합니다.
   - 길이가 같을 경우, 각 시리얼 번호에 포함된 숫자들의 합을 계산하여 오름차순으로 정렬합니다.
   - 숫자의 합이 같을 경우, 사전순으로 정렬합니다.
2. **정렬 구현**:
   - `compareBy` 함수를 이용하여 정렬 기준을 정의합니다.
   - 첫 번째 기준은 시리얼 번호의 길이, 두 번째 기준은 숫자 합, 세 번째 기준은 사전순 정렬입니다.
3. **결과 출력**:
   - 정렬된 시리얼 번호들을 하나의 문자열로 묶어 출력합니다.
   - 각 시리얼 번호는 새로운 줄로 출력되도록 문자열에 추가합니다.

### 시간 복잡도 분석:

- **정렬 작업**: 기본적으로 정렬 작업은 O(N log N) 시간 복잡도를 가집니다.
- **숫자의 합 계산**: 각 시리얼 번호에 대해 숫자의 합을 계산하는 작업은 O(M)입니다. 여기서 M은 시리얼 번호의 최대 길이입니다.
- 전체 시간 복잡도는 O(N log N * M)으로 추정됩니다.

### 세부 구현에서 중요한 부분:

1. **정렬 기준 정의**:
   - `compareBy`를 사용하여 다중 기준 정렬을 구현합니다. 이 과정에서 각 기준을 정확하게 정의하는 것이 중요합니다.
2. **숫자 합 계산**:
   - `sumOf`를 사용하여 시리얼 번호 내의 숫자들의 합을 계산하는 과정에서, 알파벳은 0으로 처리하여 계산의 정확성을 유지합니다.
3. **결과 출력**:
   - 각 시리얼 번호를 개행하여 출력할 수 있도록 문자열을 생성합니다.

## 3. 해석

### 1. **정렬 기준 정의**:

- 첫 번째 기준으로 시리얼 번호의 길이를 사용합니다. 길이가 짧은 시리얼 번호가 먼저 오도록 정렬합니다.
- 두 번째 기준은 시리얼 번호 내 숫자의 합입니다. 이 합이 작은 시리얼 번호가 먼저 오도록 정렬합니다.
- 세 번째 기준은 사전순 정렬입니다. 알파벳의 순서에 따라 시리얼 번호를 정렬합니다.

### 2. **정렬 구현**:

- `Arrays.sort`를 사용하여 시리얼 번호들을 정렬합니다. 이때 `compareBy`를 활용하여 다중 기준을 정의합니다.
- 각 기준에 따라 시리얼 번호들을 정렬한 후, 최종적으로 정렬된 리스트를 출력합니다.

### 3. **결과 출력**:

- 정렬된 시리얼 번호들을 출력 형식에 맞추어 하나의 문자열로 묶어줍니다.
- 결과 문자열은 각 시리얼 번호 사이에 개행 문자("\n")를 포함하여 작성됩니다.

## 코드 구현:

```kotlin
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Arrays

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val serialNumbers = Array<String>(n) {
        readLine()
    }
    val result = SerialNumbers.solution(serialNumbers)
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("$result\\n")
    }
}

object SerialNumbers {
    fun solution(serialNumbers: Array<String>): String {
        Arrays.sort(serialNumbers, compareBy<String> {
            it.length
        }.thenBy {
            it.sumOf { char -> if (char.isDigit()) char - '0' else 0 }
        }.thenBy {
            it
        })

        val result = StringBuilder(2550)
        for (serial in serialNumbers) {
            result.append(serial).append("\\n")
        }
        return result.toString()
    }
}

```

이 문서에서는 시리얼 번호를 정렬하는 문제를 다루었습니다. 정렬 기준을 정확하게 설정하고 이를 바탕으로 시리얼 번호들을 정렬한 후, 결과를 출력하는 방법에 대해 설명했습니다.