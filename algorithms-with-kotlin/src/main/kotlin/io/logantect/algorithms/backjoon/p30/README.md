# [백준 10610번: 30](https://www.acmicpc.net/problem/10610)

## 1. 추상화
### 문제 설명:
1. 주어진 숫자들을 조합하여 가장 큰 30의 배수를 만드는 문제이다.
2. 30의 배수는 0이 포함되어있고 모든 자릿수의 합이 3의 배수여야 한다.
3. 주어진 숫자를 재배열하여 가장 큰 30의 배수를 출력한다.
4. 불가능할 경우 -1을 출력한다.

### 목표:
1. 주어진 숫자들을 재배열하여 가장 큰 30의 배수를 찾는다.
2. 30의 배수를 만들 수 없다면 -1을 출력한다.

## 2. 계산
### 불변량(Invariant) 정의:
1. 30의 배수가 되기 위해서는 숫자에 '0'이 포함되어 있어야 한다.
2. 모든 자릿수의 합이 3의 배수여야 한다.
3. 숫자를 내림차순으로 정렬하여 가장 큰 값을 만든다.

### 알고리즘 단계:
1. 입력된 숫자 문자열을 문자 배열로 변환한다.
2. '0'이 포함되어 있는지 확인한다. 포함되어 있지 않으면 -1을 반환한다.
3. 숫자들의 합이 3의 배수인지 확인한다. 그렇지 않으면 -1을 반환한다.
4. 숫자 배열을 내림차순으로 정렬한다.
5. 정렬된 배열을 문자열로 변환하여 반환한다.

### 시간 복잡도:
- 숫자를 한 번 순회하며 '0'의 포함 여부와 숫자들의 합을 계산하므로 O(n)이다.
- 숫자 배열을 정렬하므로 O(n log n)이다.
- 전체 시간 복잡도는 O(n log n)이다.

### 공간 복잡도:
- 입력된 숫자를 문자 배열로 변환하여 저장하므로 O(n)이다.

### 코드 구현:
```kotlin
fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().toString()
    println(Thirty.solution(input))
}

object Thirty {
    fun solution(input: String): String {
        val digits = input.toCharArray()
        var zeroContained = false
        
        for (digit in digits) {
            if (digit == '0') {
                zeroContained = true
                break
            }
        }
        
        if (!zeroContained) {
            return "-1"
        }

        val sum = digits.sumOf { it.code }
        if (sum % 3 != 0) {
            return "-1"
        }
        
        digits.sortDescending()
        return digits.joinToString("")
    }
}
```

## 3. 해석

### 1. **'0' 포함 여부 확인**:

1. 주어진 숫자 문자열을 문자 배열로 변환한다.
2. 배열을 순회하며 '0'이 포함되어 있는지 확인한다.
3. '0'이 포함되어 있지 않으면 -1을 반환한다.

### 2. **숫자의 합이 3의 배수인지 확인**:

1. 숫자 배열의 합을 계산한다.
2. 합이 3의 배수가 아니면 -1을 반환한다.

### 3. **가장 큰 30의 배수 생성**:

1. 숫자 배열을 내림차순으로 정렬한다.
2. 정렬된 배열을 문자열로 변환하여 반환한다.

### 4. **결과**:

1. 주어진 숫자들을 이용하여 가장 큰 30의 배수를 생성한다.
2. 불가능할 경우 -1을 반환한다.

## 참고
1. [배수 판정법](https://blog.naver.com/alwaysneoi/100200385519)
2. [[Khan Academy] 2, 3, 4, 5, 6, 9, 10의 배수판정법](https://ko.khanacademy.org/math/pre-algebra/pre-algebra-factors-multiples/pre-algebra-divisibility-tests/v/divisibility-tests-for-2-3-4-5-6-9-10)