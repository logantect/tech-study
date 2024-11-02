# [백준 3568번: iSharp](https://www.acmicpc.net/problem/3568)

## 1. 추상화

### 문제 설명:

1. 변수 선언문이 주어졌을 때, 각 변수의 타입을 C/C++ 형식으로 변환하는 문제입니다.
2. 입력으로는 기본 타입과 여러 변수들이 포함된 선언문이 주어집니다.

### 목표:

1. 주어진 변수 선언문을 분석하여 각 변수의 타입을 변환합니다.
2. 각 변환된 변수를 새로운 줄에 출력합니다.
3. 시간 제한 2초, 메모리 제한 128MB.

#### 입력 예제:

```plaintext
int& a*[], b, c*;
```

#### 출력 예제:

```plaintext
int& a*[];
int b;
int* c;
```

## 2. 계산

### 불변량(Invariant) 정의:

1. 변수 선언문에서 기본 타입과 각 변수의 접미사 및 접두사를 정확히 분리하여 처리할 수 있습니다.
2. 변수의 타입과 이름을 정확히 추출하여 변환된 결과를 출력할 수 있습니다.

### 알고리즘 단계:

1. **입력 파싱**:
    - 첫 줄에서 변수 선언문을 읽습니다.
2. **기본 타입과 변수들 분리**:
    - `StringTokenizer`를 사용하여 기본 타입과 변수들을 분리합니다.
3. **각 변수의 타입 변환**:
    - 각 변수에 대해 접두사와 접미사를 분리하고, 기본 타입에 추가합니다.
    - 변수의 이름과 변환된 타입을 조합하여 출력 형식을 맞춥니다.

### 시간 복잡도:

- O(N), N은 변수 선언문의 길이입니다.

### 공간 복잡도:

- O(N), N은 변수 선언문의 길이입니다.

### 코드 구현:

```kotlin
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val output = ISharp.solution(firstLine)
    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        output.forEach {
            writer.write("$it\\n")
        }
    }
}

object ISharp {
    fun solution(variableDeclaration: String): List<String> {
        val variablesTokenizer = StringTokenizer(variableDeclaration, " ,;")
        val type = variablesTokenizer.nextToken()
        val results = mutableListOf<String>()
        while (variablesTokenizer.hasMoreTokens()) {
            val variableTypeBuilder = StringBuilder(type)
            val variablePart = variablesTokenizer.nextToken()
            val variable = variablePart.filter { it.isLetterOrDigit() }
            for (i in variablePart.indices.reversed()) {
                when (variablePart[i]) {
                    '&' -> variableTypeBuilder.append('&')
                    '[' -> variableTypeBuilder.append("[]")
                    '*' -> variableTypeBuilder.append('*')
                }
            }
            results.add("$variableTypeBuilder $variable;")
        }
        return results.toList()
    }
}

```

### 단위 테스트 코드

```kotlin
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ISharpTest {
    @Test
    fun testExample1() {
        val input = "int& a*"
        val expected = listOf("int& a;")
        assertEquals(expected, ISharp.solution(input))
    }

    @Test
    fun testExample2() {
        val input = "int a, b, c;"
        val expected = listOf("int a;", "int b;", "int c;")
        assertEquals(expected, ISharp.solution(input))
    }

    @Test
    fun testExample3() {
        val input = "int* a, b[], c*;"
        val expected = listOf("int* a;", "int[] b;", "int* c;")
        assertEquals(expected, ISharp.solution(input))
    }
}

```

### 다른 문제 풀이

```kotlin
import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val input = StringTokenizer(br.readLine())

    val basicType = input.nextToken()
    while (input.hasMoreTokens()) {
        val cur = input.nextToken()
        val stack = Stack<Char>()
        val name = StringBuilder()
        for (c in cur) {
            if (c == ',' || c == ';') {
                break
            }

            if (isAlpha(c)) {
                name.append(c)
            } else {
                stack.push(c)
            }
        }

        val type = if (stack.isEmpty()) basicType else "$basicType${makeFullType(stack)}"

        bw.write("$type $name;")
        bw.newLine()


        bw.close()
        br.close()
    }

    private fun isAlpha(ch: Char) = ch in 'a'..'z' || ch in 'A'..'Z'

    private fun makeFullType(stack: Stack<Char>): String {
        val sb = StringBuilder()

        while (stack.isNotEmpty()) {
            if (stack.peek() == ']') {
                val close = stack.pop()
                sb.append(stack.pop())
                sb.append(close)
            } else {
                sb.append(stack.pop())
            }
        }

        return sb.toString()
    }
```

### 구조적 차이

- **내 코드**:
    - `StringTokenizer`로 기본 타입과 변수들을 분리합니다.
    - `filter`와 `StringBuilder`를 사용하여 변수의 타입을 조합합니다.
    - `results` 리스트에 변환된 변수를 추가하고 최종 결과를 반환합니다.
- **다른 사람의 코드**:
    - `StringTokenizer`로 기본 타입과 변수들을 분리합니다.
    - `Stack`과 `StringBuilder`를 사용하여 변수의 타입을 조합합니다.
    - 결과를 바로 `BufferedWriter`에 씁니다.

### 시간 복잡도

- **내 코드**: 시간 복잡도는 O(N)입니다. 변수 선언문의 길이에 따라 처리합니다.
- **다른 사람의 코드**: 시간 복잡도는 O(N)입니다. 변수 선언문의 길이에 따라 처리합니다.

### 공간 복잡도

- **내 코드**: `List`와 `StringBuilder`를 사용하여 공간을 추가로 사용합니다.
- **다른 사람의 코드**: `Stack`과 `StringBuilder`를 사용하여 공간을 추가로 사용합니다.

### 불변량(Invariant) 정의

- **내 코드**:
    - 변수의 타입을 조합하고 변환하는 과정에서 불변성을 유지합니다.
- **다른 사람의 코드**:
    - 변수의 타입을 조합하고 변환하는 과정에서 불변성을 유지합니다.

### 결론

- 두 코드의 주요 차이점은 변수의 타입을 조합하고 결과를 출력하는 방식이다.
- 내 코드는 결과를 리스트로 저장한 후 한 번에 출력하며, 다른 사람의 코드는 `Stack`을 사용하여 실시간으로 결과를 출력한다.
- 두 방식 모두 시간 및 공간 복잡도 면에서 비슷하다.