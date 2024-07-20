## [백준 2980번: 도로와 신호등](https://www.acmicpc.net/problem/2980)

## 1. 추상화

### 문제 설명:

1. 상근이는 트럭을 타고 일직선 도로를 운전합니다.
2. 도로에는 여러 개의 신호등이 설치되어 있으며, 각 신호등은 빨간 불과 초록 불이 번갈아가며 켜집니다.
3. 상근이가 도로의 끝까지 이동하는 데 걸리는 시간을 계산합니다.

### 목표:

1. 주어진 신호등 정보에 따라 상근이가 도로의 끝까지 이동하는 데 걸리는 시간을 계산합니다.
2. 시간 제한 1초, 메모리 제한 128MB.

## 2. 계산

### 불변량(Invariant) 정의:
이 문제에서는 주기의 어떤 시점에 도착하더라도, 그 시점의 빨간 불 또는 초록 불 상태를 정확히 계산할 수 있는 것이 불변량입니다.
이를 통해 신호등에서 대기 시간을 정확히 계산할 수 있습니다.

- **현재 시간에서 신호등 주기의 시간 계산**: `travelTime % (r + g)`
- **빨간 불 지속 시간 안에 있는지 확인**: `if (timeInCycle < r)`

### 알고리즘 단계:

1. **입력 파싱**:
   - 첫 줄에서 신호등의 개수 `n`과 도로의 길이 `l`을 읽습니다.
   - 각 신호등의 위치 `d`, 빨간 불 지속 시간 `r`, 초록 불 지속 시간 `g`를 `Map`에 저장합니다.
2. **시간 계산**:
   - 초기 위치와 시간을 0으로 설정합니다.
   - 각 신호등에 대해 현재 위치에서 신호등까지의 거리를 더해 이동 시간을 계산합니다.
   - 신호등에 도착했을 때 주기 내 현재 시간을 계산하여 빨간 불 지속 시간에 해당하면 대기합니다.
3. **결과 출력**:
   - 마지막 신호등을 지나 도로의 끝까지 이동하는 시간을 더해 출력합니다.

### 시간 복잡도:

- 입력을 처리하고 시간을 계산하는 데 O(N)의 시간이 소요됩니다.

### 공간 복잡도:

- 입력된 신호등 정보를 저장하는 데 O(N)의 공간이 필요합니다.

### 코드 구현:

```kotlin
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
   val firstLine = readLine()
   val stringTokenizer = StringTokenizer(firstLine)
   val n = stringTokenizer.nextToken().toInt()
   val l = stringTokenizer.nextToken().toInt()

   val trafficLights = mutableMapOf<Int, Pair<Int, Int>>()
   repeat(n) {
      val tokenizer = StringTokenizer(readLine())
      val d = tokenizer.nextToken().toInt()
      val r = tokenizer.nextToken().toInt()
      val g = tokenizer.nextToken().toInt()
      trafficLights[d] = r to g
   }

   val travelTime = RoadWithTrafficLight.solution(l, trafficLights)
   BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
      writer.write("$travelTime\n")
   }
}

object RoadWithTrafficLight {
   fun solution(totalDistance: Int, trafficLights: Map<Int, Pair<Int, Int>>): Int {
      var travelTime = 0
      for (i in 0 until totalDistance) {
         trafficLights[i]?.let {
            val timeInCycle = travelTime % (it.first + it.second)
            if (timeInCycle < it.first) {
               travelTime += (it.first - timeInCycle)
            }
         }
         travelTime++
      }
      return travelTime
   }
}
```

## 3. 해석

### 1. **입력 파싱**:

- 신호등의 개수 `n`과 도로의 길이 `l`을 첫 줄에서 읽습니다.
- 각 신호등의 위치 `d`, 빨간 불 지속 시간 `r`, 초록 불 지속 시간 `g`를 `Map`에 저장합니다.

### 2. **시간 계산**:

- 초기 위치와 시간을 0으로 설정합니다.
- 각 신호등에 도착할 때까지 걸리는 시간을 더하고, 신호등에 도착했을 때 주기 내 현재 시간을 계산하여 빨간 불 지속 시간에 해당하면 대기 시간을 추가합니다.
- 신호등의 빨간 불과 초록 불 주기를 이용해 현재 신호 상태를 계산합니다.

### 3. **결과 출력**:

- 모든 신호등을 지나 도로의 끝까지 이동하는 시간을 출력합니다.

### 불변량 적용:

- `val timeInCycle = travelTime % (it.first + it.second)` : 현재 시간을 신호 주기 내 시간으로 변환합니다.
- `if (timeInCycle < it.first) { travelTime += (it.first - timeInCycle) }` : 현재 시간이 빨간 불 시간 내에 있다면 빨간 불이 끝날 때까지 대기 시간을 추가합니다.

### 예시

1. 주어진 입력:

    ```
    2 10
    3 5 5
    5 2 2
    
    ```

2. 시간 계산:
   - 3초 동안 이동 후 첫 번째 신호등 도착
   - 빨간 불 5초 동안 대기 후 초록 불로 변경, 총 8초 경과
   - 2초 동안 이동 후 두 번째 신호등 도착
   - 빨간 불 2초 동안 대기 후 초록 불로 변경, 총 11초 경과
   - 나머지 5초 동안 이동하여 총 16초가 소요됩니다.
3. 최종 출력:

    ```
    16
    ```