## [백준 3048번: 개미](https://www.acmicpc.net/problem/3048)

### 1. 추상화

### 문제 설명:

1. 두 그룹의 개미들이 서로 반대 방향으로 움직이다가 만났을 때, 시간이 흐르면서 개미들의 위치가 어떻게 변하는지 시뮬레이션하는 문제입니다.
2. 두 그룹의 개미는 초기 위치가 주어지며, 시간이 흐름에 따라 서로 자리를 바꿉니다.

### 문제 상세 설명
- 첫 번째 그룹이 ABC로 움직이고, 두 번째 그룹의 개미가 DEF순으로 움직인다고 하자. 그럼, 좁은 길에서 만났을 때, 개미의 순서는 CBADEF가 된다. 1초가 지났을 때는 자신의 앞에 반대방향으로 움직이는 개미가 있는 개미는 A와 D다. 따라서, 개미의 순서는 CBDAEF가 된다. 2초가 되었을 때, 자신의 앞에 반대 방향으로 움직이는 개미는 B,D,A,E가 있다. 따라서, 개미의 순서는 CDBEAF가 된다.

### 목표:

1. 주어진 두 그룹의 개미 위치와 시간에 따라 최종 위치를 계산합니다.
2. 시간 제한 1초, 메모리 제한 128MB. 

#### 입력 예제:

```plaintext
3 3
ABC
DEF
2
```

#### 출력 예제:

```plaintext
CDBEAF
```

### 2. 계산

### 불변량(Invariant) 정의:

1. 개미들은 서로 위치를 바꾸는 동안 상대 그룹의 개미와 충돌하여 자리를 바꿉니다.
2. 각 시간 단위마다 각 개미의 위치는 다음과 같이 변합니다:
   - 개미가 반대 그룹의 개미와 충돌하면 자리를 바꿉니다.

### 알고리즘 단계:

1. **입력 파싱**:
   - 첫 줄에서 두 그룹의 개미 수 `n1`과 `n2`를 읽습니다.
   - 두 번째 줄에서 첫 번째 그룹의 개미 순서를 읽습니다.
   - 세 번째 줄에서 두 번째 그룹의 개미 순서를 읽습니다.
   - 네 번째 줄에서 주어진 시간을 읽습니다.
2. **개미 위치 초기화**:
   - 첫 번째 그룹의 개미는 역순으로 배열에 저장합니다.
   - 두 번째 그룹의 개미는 그대로 배열에 저장합니다.
3. **시간 경과 시뮬레이션**:
   - 주어진 시간 동안 개미들이 서로 자리를 바꾸는 시뮬레이션을 수행합니다.
4. **결과 출력**:
   - 최종 위치를 문자열로 변환하여 출력합니다.

### 시간 복잡도:

- 시간 경과 시뮬레이션을 수행하는 데 O(T * (n1 + n2))의 시간이 소요됩니다. 여기서 T는 시간, n1과 n2는 두 그룹의 개미 수입니다.

### 공간 복잡도:

- 개미 위치를 저장하는 데 O(n1 + n2)의 공간이 필요합니다.

### 코드 구현:

```kotlin
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val stringTokenizer = StringTokenizer(firstLine)
    val n1 = stringTokenizer.nextToken().toInt()
    val n2 = stringTokenizer.nextToken().toInt()
    val output = Ant.solution(
        n1 = n1,
        n2 = n2,
        inputGroup1 = readLine(),
        inputGroup2 = readLine(),
        time = readLine().toInt()
    )

    BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
        writer.write("$output\\n")
    }
}

object Ant {
    fun solution(
        n1: Int,
        n2: Int,
        inputGroup1: String,
        inputGroup2: String,
        time: Int,
    ): String {
        val totalLength = n1 + n2
        val ants = CharArray(totalLength)

        // 첫 번째 그룹의 개미를 역순으로 배열에 저장
        for (i in 0 until n1) {
            ants[i] = inputGroup1[n1 - 1 - i]
        }
        // 두 번째 그룹의 개미를 배열에 저장
        for (i in 0 until n2) {
            ants[n1 + i] = inputGroup2[i]
        }

        val group1Set = inputGroup1.toSet()
        val group2Set = inputGroup2.toSet()

        // 주어진 시간 동안 개미들이 서로 자리를 바꾸는 시뮬레이션
        repeat(time) {
            var i = 0
            while (i < totalLength - 1) {
                // 첫 번째 그룹의 개미와 두 번째 그룹의 개미가 만나면 자리 바꾸기
                if (ants[i] in group1Set && ants[i + 1] in group2Set) {
                    val temp = ants[i]
                    ants[i] = ants[i + 1]
                    ants[i + 1] = temp
                    i++
                }
                i++
            }
        }
        // 최종 위치를 문자열로 변환하여 반환
        return ants.joinToString("")
    }
}

```

### 3. 해석

### 1. **입력 파싱**:

- 첫 번째 줄에서 두 그룹의 개미 수 `n1`과 `n2`를 읽습니다.
- 두 번째 줄에서 첫 번째 그룹의 개미 순서를 읽습니다.
- 세 번째 줄에서 두 번째 그룹의 개미 순서를 읽습니다.
- 네 번째 줄에서 주어진 시간을 읽습니다.

### 2. **개미 위치 초기화**:

- 첫 번째 그룹의 개미를 역순으로 배열에 저장합니다.
- 두 번째 그룹의 개미를 그대로 배열에 저장합니다.

### 3. **시간 경과 시뮬레이션**:

- 주어진 시간 동안 각 시간 단위마다 개미들이 서로 자리를 바꾸는 시뮬레이션을 수행합니다.
- 첫 번째 그룹의 개미가 두 번째 그룹의 개미와 만나면 자리를 바꿉니다.

### 4. **결과 출력**:

- 최종 위치를 문자열로 변환하여 출력합니다.

### 예시

1. 주어진 입력:

    ```
    3 3
    ABC
    DEF
    2
    ```

2. 시간 계산:
   - 초기 상태: `CBADEF`
   - 1초 후: `CBDAEF`
   - 2초 후: `CDBEAF`
3. 최종 출력:
    ```
    CDBEAF
    ```

### 다른 문제 풀이와 비교

```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

enum class Direction {
    LEFT, RIGHT
}

data class Ant(
        var name: Char,
        var dir: Direction
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    val sizeGroupA = token.nextToken().toInt()
    val sizeGroupB = token.nextToken().toInt()

    val strGroupA = br.readLine()
    val strGroupB = br.readLine()

    val time = br.readLine().toInt()

    val listAnt = arrayListOf<Ant>()

    for (i in strGroupA.length - 1 downTo 0) {
        listAnt.add(Ant(strGroupA[i], Direction.RIGHT))
    }

    for (i in strGroupB.indices) {
        listAnt.add(Ant(strGroupB[i], Direction.LEFT))
    }

    var ignoreNum = -1
    for (t in 1..time) {
        for (i in 0..listAnt.size - 2) {
            if (listAnt[i].dir == Direction.RIGHT && listAnt[i + 1].dir == Direction.LEFT) {
                if (ignoreNum != i) {
                    var temp = listAnt[i]
                    listAnt[i] = listAnt[i + 1]
                    listAnt[i + 1] = temp
                    ignoreNum = i + 1
                }
            }
        }
        ignoreNum = -1
    }

    var result = ""
    listAnt.forEach {
        result += it.name
    }

    print(result)
}

```

### 비교:

### 구조적 차이:

- **내 문제 풀이**: 개미를 `CharArray`로 저장하고, 두 개미 그룹의 상태를 `Set`으로 관리합니다. 시간 경과에 따라 개미들이 자리를 바꾸는 시뮬레이션을 수행합니다.
- **다른 문제 풀이**: 개미의 이동 방향을 `Direction` enum으로 정의하고, `Ant` 데이터 클래스를 사용하여 개미의 상태를 나타냅니다. 각 개미는 `listAnt` 리스트에 저장되며, 시간 경과에 따라 개미들이 자리를 바꾸는 시뮬레이션을 수행합니다.

### 시간 복잡도:

- **내 문제 풀이**: 시간 복잡도는 O(T * N)이며, T는 시간, N은 개미 수입니다. 각 시간 단위마다 개미들의 상태를 확인하고, 자리를 바꿉니다.
- **다른 문제 풀이**: 시간 복잡도는 O(T * N)이며, T는 시간, N은 개미 수입니다. 각 시간 단위마다 개미들의 상태를 확인하고, 자리를 바꿉니다.

### 공간 복잡도:

- **내 문제 풀이**: 개미의 상태를 저장하는 `CharArray`와 두 개미 그룹의 상태를 나타내는 `Set`을 사용하여 추가적인 공간을 사용합니다.
- **다른 문제 풀이**: 개미의 상태를 저장하는 `listAnt` 리스트와 `Direction` enum을 사용하여 추가적인 공간을 사용합니다.

### 불변량(Invariant) 정의:

- **내 문제 풀이**: 개미의 상태를 `CharArray`로 정의하고, 두 개미 그룹의 상태를 `Set`으로 나타냅니다. 개미가 서로 만나면 자리를 바꿉니다.
- **다른 문제 풀이**: 개미의 상태를 `Ant` 데이터 클래스로 정의하고, 각 개미의 방향을 `Direction` enum으로 나타냅니다. 개미가 서로 만나면 자리를 바꿉니다.
