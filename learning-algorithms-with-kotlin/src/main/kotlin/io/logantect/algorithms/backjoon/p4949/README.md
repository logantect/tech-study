# [백준 4949번: 균형잡힌 세상](https://www.acmicpc.net/problem/4949)

## 1. 추상화

### 문제 설명:

1. 주어진 문자열에서 소괄호 `()`와 대괄호 `[]`의 균형이 맞는지 확인하는 문제입니다.
2. 문자열에는 여러 문자가 포함될 수 있지만, 문제에서는 괄호의 균형만을 확인합니다.
3. 입력의 끝은 `.`으로 주어집니다.

### 목표:

1. 각 줄마다 괄호가 균형이 맞는 경우에는 "yes", 맞지 않는 경우에는 "no"를 출력합니다.
2. 입력이 종료될 때까지 이 과정을 반복합니다.
3. 시간 제한 1초, 메모리 제한 128MB.

### 입력 예제:

```
So when I die (the [first] I will see in (heaven)) is a score list.
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
 .
.

```

### 출력 예제:

```
yes
yes
no
no
no
yes

```

## 2. 계산

### 불변량(Invariant) 정의:

1. 열리는 괄호 `(`, `[`가 나올 때마다 스택에 추가하고, 닫히는 괄호 `)` 또는 `]`가 나올 때마다 스택에서 해당 짝이 맞는 열리는 괄호를 제거해야 합니다.
2. 모든 괄호가 짝을 이루어야만 스택이 비어있게 되어 균형이 맞다고 판단할 수 있습니다.

### 알고리즘 단계:

1. **입력 반복 처리**:
   - 한 줄씩 문자열을 읽어옵니다.
   - 종료 조건으로 `.`이 입력되면 반복을 종료합니다.
2. **스택을 이용한 괄호 균형 체크**:
   - 문자열을 순회하면서 열리는 괄호 `(`, `[`가 나오면 스택에 추가합니다.
   - 닫히는 괄호 `)`, `]`가 나오면 스택에서 짝이 맞는 열리는 괄호를 제거합니다.
   - 스택이 비어있지 않거나 짝이 맞지 않으면 균형이 맞지 않다고 판단하여 "no"를 출력합니다.
3. **균형 판단**:
   - 모든 문자를 처리한 후 스택이 비어있으면 균형이 맞는 것으로 판단하여 "yes"를 출력하고, 그렇지 않으면 "no"를 출력합니다.

### 시간 복잡도:

- O(N), N은 문자열의 길이입니다.

### 공간 복잡도:

- O(N), N은 문자열의 길이입니다.

### 코드 구현:

```kotlin
import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()) {
    val output = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val line = readLine()
        if (line == ".") break

        if (WorldInBalance.solution(line)) {
            output.write("yes\\n")
        } else {
            output.write("no\\n")
        }
    }

    output.flush()
    output.close()
}

object WorldInBalance {
    fun solution(input: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (char in input) {
            when (char) {
                '(', '[' -> stack.addFirst(char)
                ')' -> {
                    val lastOpen = if (stack.isNotEmpty()) {
                        stack.removeFirst()
                    } else {
                        return false
                    }
                    if (lastOpen != '(') return false
                }

                ']' -> {
                    val lastOpen = if (stack.isNotEmpty()) {
                        stack.removeFirst()
                    } else {
                        return false
                    }
                    if (lastOpen != '[') return false
                }
            }
        }
        return stack.isEmpty()
    }
}

```

## 3. 해석

### 1. **입력 처리**:

- 입력이 종료될 때까지 각 줄을 읽고, 한 줄씩 처리합니다.
- `.`이 입력되면 반복을 종료합니다.

### 2. **스택을 이용한 괄호 균형 체크**:

- 열린 괄호는 스택에 추가하고, 닫힌 괄호가 나오면 스택에서 마지막으로 추가된 열린 괄호를 제거하여 균형을 체크합니다.
- 스택이 비어있거나 짝이 맞지 않는 경우는 즉시 "no"를 반환합니다.

### 3. **균형 판단**:

- 모든 문자열을 처리한 후 스택이 비어있는지 확인합니다. 스택이 비어있으면 균형이 맞다고 판단하여 "yes"를 반환하고, 그렇지 않으면 "no"를 반환합니다.

### 예시

- 입력:

```
So when I die (the [first] I will see in (heaven)) is a score list.
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
 .
.

```

- 출력:

```
yes
yes
no
no
no
yes

```

이 코드와 알고리즘은 문자열에서 괄호의 균형을 효율적으로 검사할 수 있습니다.