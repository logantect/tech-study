# [백준 6550번: 부분 문자열](https://www.acmicpc.net/problem/6550)

## 1. 추상화
### 문제 설명:
1. 두 문자열 `s`와 `t`가 주어진다.
2. 문자열 `s`가 문자열 `t`의 부분 문자열(subsequence)인지 확인하는 문제이다.
3. `s`의 문자들이 `t`의 문자들 사이에서 순서를 유지하면서 나타나면 부분 문자열이다.
4. 시간 제한: 1초
5. 메모리 제한: 128MB

### 목표:
1. 문자열 `s`가 문자열 `t`의 부분 문자열인지 여부를 확인하여 `Yes` 또는 `No`를 출력한다.

## 2. 계산
### 불변량(Invariant) 정의:
1. 문자열 `s`의 각 문자가 `t`에서 순서대로 나타나야 한다.

### 알고리즘 단계:
1. 입력으로 여러 줄의 문자열 쌍을 받는다.
2. 각 문자열 쌍 `s`와 `t`에 대해:
    - `s`의 각 문자가 `t`에서 순서대로 나타나는지 확인한다.
    - 이를 위해 두 개의 인덱스를 사용하여 `s`와 `t`를 순회한다.
3. `s`의 모든 문자가 `t`에서 순서대로 나타나면 `Yes`를 출력하고, 그렇지 않으면 `No`를 출력한다.

### 시간 복잡도:
- 이 방법은 t를 한 번 순회하면서 s의 문자를 차례로 찾아가기 때문에 시간 복잡도는 O(n + m)이다.
- 여기서 n은 t의 길이, m은 s의 길이이다.

### 공간 복잡도:
- 입력을 저장하기 위한 공간 외에 추가적인 메모리를 사용하지 않는다.
- 공간 복잡도는 O(1)이다.


### 코드 구현:
```kotlin
fun main() = with(System.`in`.bufferedReader()) {
    val readLines = mutableListOf<String>()
    while (true) {
        val line = readLine() ?: break
        readLines.add(line)
    }
    Substring.solution(readLines)
}

object Substring {
    fun solution(strList: List<String>) {
        strList.forEach {
            val (s, t) = it.split(" ")
            var sIndex = 0

            t.forEach { char ->
                if (sIndex < s.length && s[sIndex] == char) {
                    sIndex++
                }
            }

            if (sIndex == s.length) {
                println("Yes")
            } else {
                println("No")
            }
        }
    }
}
```

## 3. 해석
### 1. **첫 번째 수와 두 번째 수 선택**:
1. 첫 번째 문자열 `s`는 예제에서 주어진 `"abc"`이다.
2. 두 번째 문자열 `t`는 예제에서 주어진 `"aebdc"`이다.

### 2. **부분 문자열 확인**:
1. 문자열 `s`의 각 문자가 `t`에서 순서대로 나타나는지 확인한다.
2. `s`의 첫 번째 문자는 `'a'`이고, `t`의 첫 번째 문자는 `'a'`이므로 일치한다. 다음 문자를 비교한다.
3. `s`의 두 번째 문자는 `'b'`이고, `t`의 두 번째 문자는 `'e'`이므로 일치하지 않는다. `t`의 다음 문자를 비교한다.
4. `t`의 세 번째 문자는 `'b'`이고, `s`의 두 번째 문자는 `'b'`이므로 일치한다. 다음 문자를 비교한다.
5. `s`의 세 번째 문자는 `'c'`이고, `t`의 네 번째 문자는 `'d'`이므로 일치하지 않는다. `t`의 다음 문자를 비교한다.
6. `t`의 다섯 번째 문자는 `'c'`이고, `s`의 세 번째 문자는 `'c'`이므로 일치한다. 더 이상 비교할 문자가 없다.

### 3. **부분 문자열 여부 결정**:
1. 문자열 `s`의 모든 문자가 `t`에서 순서대로 나타났으므로 `s`는 `t`의 부분 문자열이다.
2. 따라서, 결과는 `Yes`이다.

### 4. **결과**:
1. 문자열 `s = "abc"`와 `t = "aebdc"`의 경우, `s`는 `t`의 부분 문자열이므로 결과는 `Yes`이다.
2. 다양한 입력 값에 대해 이 과정을 반복하여 결과를 확인한다.

## 예제 입력과 출력

**예제 입력:**
```
abc aebdc
ace abcde
aec abcde
```

**예제 출력:**
```
Yes
Yes
No
```

## 4. 다른 문제풀이와 비교

### 첫 번째 방법 (기존 방법)

**코드 요약:**
```kotlin
fun main() = with(System.`in`.bufferedReader()) {
    val readLines = mutableListOf<String>()
    while (true) {
        val line = readLine() ?: break
        readLines.add(line)
    }
    Substring.solution(readLines)
}

object Substring {
    fun solution(strList: List<String>) {
        strList.forEach {
            val (s, t) = it.split(" ")
            var sIndex = 0

            t.forEach { char ->
                if (sIndex < s.length && s[sIndex] == char) {
                    sIndex++
                }
            }

            if (sIndex == s.length) {
                println("Yes")
            } else {
                println("No")
            }
        }
    }
}
```

**시간 복잡도:**
- 이 방법은 `t`를 한 번 순회하면서 `s`의 문자를 차례로 찾아가기 때문에 시간 복잡도는 O(n + m)이다.
- 여기서 `n`은 `t`의 길이, `m`은 `s`의 길이이다.

**공간 복잡도:**
- 입력을 저장하기 위한 공간 외에 추가적인 메모리를 사용하지 않는다.
- 공간 복잡도는 O(1)이다.

### 두 번째 방법 (새로운 방법)

**코드 요약:**
```kotlin
fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val input = readLine() ?: break
        val (s, t) = input.split(" ")

        var start = 0
        var result = "Yes"
        for (c in s) {
            start = t.indexOf(c, start) + 1
            if (start == 0) {
                result = "No"
            }
        }
        println(result)
    }

    close()
}
```

**시간 복잡도:**
- 이 방법은 `s`의 각 문자에 대해 `t.indexOf`를 호출한다. `t.indexOf`는 내부적으로 `t`를 순회하며 문자를 찾기 때문에 최악의 경우 시간 복잡도는 O(n * m)이 될 수 있다.
- 여기서 `n`은 `t`의 길이, `m`은 `s`의 길이이다.

**공간 복잡도:**
- 입력을 저장하기 위한 공간 외에 추가적인 메모리를 사용하지 않는다.
- 공간 복잡도는 O(1)이다.

### 결론
첫 번째 방법이 시간 복잡도 면에서 더 효율적이다. 두 번째 방법은 `t.indexOf`의 호출 횟수 때문에 최악의 경우 더 많은 시간이 걸릴 수 있다. 따라서, 큰 입력에 대해 효율성을 중시한다면 첫 번째 방법을 사용하는 것이 좋다.