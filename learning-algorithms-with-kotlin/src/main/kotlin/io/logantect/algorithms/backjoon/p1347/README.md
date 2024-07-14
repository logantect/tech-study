### [백준 1347번: 미로 만들기](https://www.acmicpc.net/problem/1347)

## 1. 추상화

### 문제 설명:

1. 주어진 명령에 따라 미로를 그립니다.
2. 초기 위치는 남쪽을 바라보고 있으며, 'F'는 전진, 'L'은 왼쪽으로 회전, 'R'은 오른쪽으로 회전합니다.

### 목표:

1. 주어진 명령에 따라 미로의 경로를 그리고, 미로를 출력합니다.
2. 시간 제한 2초, 메모리 제한 128MB.

## 2. 계산

### 불변량(Invariant) 정의:

1. 초기 위치는 (0, 0)이고, 남쪽을 바라보고 있습니다.
2. 명령에 따라 위치와 방향이 변합니다.
3. 미로의 크기는 명령의 결과로 결정됩니다.

### 알고리즘 단계:

1. **초기 설정**:
   1. 방향을 남(S), 동(E), 북(N), 서(W) 순서로 설정합니다. 
   2. 2.초기 방향을 남쪽으로 설정합니다.
2. **명령 처리**:
   1. 'F' 명령은 현재 방향으로 한 칸 전진합니다.
   2. 'L' 명령은 왼쪽으로 90도 회전합니다.
   3. 'R' 명령은 오른쪽으로 90도 회전합니다.
   4. 왼쪽 오른쪽은 관찰자 기준이다.
3. **미로 범위 계산**:
   1. 경로를 따라 이동하면서 최소 및 최대 x, y 좌표를 계산합니다.
4. **미로 그리기**:
   1. 계산된 범위 내에서 미로를 그립니다.

### 시간 복잡도:

- 명령을 처리하는 데 O(n) 시간이 소요됩니다.
- 미로를 그리는 데 O(m * n)의 시간이 소요됩니다. 여기서 m과 n은 미로의 세로 및 가로 크기입니다.
- 전체 시간 복잡도는 주어진 명령의 길이에 따라 O(n)입니다.

### 공간 복잡도:

- 경로를 저장하기 위해 O(n)의 공간이 필요합니다.

### 코드 구현:

```kotlin
package io.logantect.algorithms.backjoon.p1347

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    if (n > 50) {
        return
    }
    val commands = readLine()
    println(MazeMaker.solution(commands))
}

object MazeMaker {
    fun solution(message: String?): String {
        if (message == null) return ""

        var x = 0
        var y = 0
        // 남(S), 동(E), 북(N), 서(W) 순서로 방향 설정
        val directions = listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))
        var dirIndex = 0  // 초기 방향을 남쪽(S)로 설정
        val path = mutableListOf(Pair(x, y))

        message.forEach { command ->
            when (command) {
                'F' -> {
                    x += directions[dirIndex].first
                    y += directions[dirIndex].second
                    path.add(Pair(x, y))
                }
                'L' -> dirIndex = (dirIndex + 1) % 4  // 왼쪽 회전은 인덱스를 1 증가
                'R' -> dirIndex = (dirIndex + 3) % 4  // 오른쪽 회전은 인덱스를 3 증가 (역방향 회전)
            }
        }

        // 미로 범위 계산
        val minX = path.minOf { it.first }
        val maxX = path.maxOf { it.first }
        val minY = path.minOf { it.second }
        val maxY = path.maxOf { it.second }

        // 미로 그리기
        val maze = Array(maxY - minY + 1) { CharArray(maxX - minX + 1) { '#' } }
        path.forEach { (px, py) ->
            maze[py - minY][px - minX] = '.'
        }
        return maze.joinToString("\\n") { it.joinToString("") }
    }
}

```

## 3. 해석

### 1. **초기 설정**:

- 초기 위치는 (0, 0)이며, 방향은 남쪽(인덱스 0)으로 설정합니다.

### 2. **명령 처리**:

- 'F' 명령은 현재 방향으로 한 칸 전진합니다.
- 'L' 명령은 왼쪽으로 회전하여 인덱스를 1 증가시킵니다.
- 'R' 명령은 오른쪽으로 회전하여 인덱스를 3 증가시킵니다.

### 3. **미로 범위 계산**:

- 경로를 따라 이동하면서 최소 및 최대 x, y 좌표를 계산합니다.

### 4. **미로 그리기**:

- 계산된 범위 내에서 미로를 그립니다.

### 5. **2차원 배열과 좌표 체계 **
2차원 배열과 좌표 체계
배열 maze를 좌표로 나타내면:
```scss
(0, 0) (1, 0)
(0, 1) (1, 1)
```
여기서 y가 먼저 오고 x가 그 다음에 옵니다.

배열의 각 요소는 다음과 같이 매핑됩니다:

- maze[0][0]: (0, 0)
- maze[0][1]: (1, 0)
- maze[1][0]: (0, 1)
- maze[1][1]: (1, 1)
