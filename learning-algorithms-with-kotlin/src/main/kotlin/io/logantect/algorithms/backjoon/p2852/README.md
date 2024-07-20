# [백준 2852번: NBA 농구](https://www.acmicpc.net/problem/2852)

## 1. 추상화

### 문제 설명:

1. 농구 경기는 총 48분 동안 진행되며, 각 팀이 언제 리드를 했는지 기록을 통해 확인할 수 있습니다.
2. 팀 1과 팀 2의 득점 시각이 주어질 때, 각 팀이 리드한 총 시간을 계산합니다.

### 목표:

1. 주어진 득점 시각을 통해 각 팀이 리드한 총 시간을 계산하여 출력합니다.
2. 시간 제한 1초, 메모리 제한 128MB.

## 2. 계산

### 불변량(Invariant) 정의:

1. 경기는 48분 동안 진행되며, 이는 2880초(48 * 60)로 변환됩니다.
2. 득점 시각은 "분:초" 형식으로 주어집니다.
3. 각 팀의 득점을 시간순으로 처리하여 리드 시간을 계산합니다.

### 알고리즘 단계:

1. **입력 파싱**:
   - 각 팀의 득점 시각을 "분:초" 형식으로 받아, 이를 초 단위로 변환하여 저장합니다.
2. **리드 시간 계산**:
   - 0초부터 2880초까지 각 초마다 리드한 팀을 계산합니다.
   - 득점이 있을 때마다 해당 팀의 점수를 증가시킵니다.
   - 각 초마다 리드한 팀을 확인하고, 해당 팀의 리드 시간을 증가시킵니다.
3. **결과 출력**:
   - 각 팀의 리드 시간을 "분:초" 형식으로 변환하여 출력합니다.

### 시간 복잡도:

- 득점 시각을 초 단위로 변환하고, 2880초를 순회하며 리드 시간을 계산하는 데 O(n + 2880) 시간이 소요됩니다.
- 여기서 `n`은 득점 시각의 수입니다.

### 공간 복잡도:

- 득점 시각을 저장하는 데 O(n)의 공간이 필요합니다.

### 코드 구현:

```kotlin
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val messages = mutableListOf<String>()

    repeat(n) {
        messages.add(readLine())
    }

    NBA.solution(messages)
}

object NBA {
    fun solution(list: List<String>) {
        val gameTimeSecond = 48 * 60
        val result = mutableMapOf<Int, String>()

        list.forEach {
            val tokenizer = StringTokenizer(it)
            val id = tokenizer.nextToken()
            val time = tokenizer.nextToken()
            val timeTokenizer = StringTokenizer(time, ":")
            val minutes = timeTokenizer.nextToken().toInt()
            val seconds = timeTokenizer.nextToken().toInt()
            val totalSeconds = minutes * 60 + seconds
            result[totalSeconds] = id
        }

        var a = 0
        var b = 0
        var aWinTime = 0
        var bWinTime = 0

        for (i in 0 until gameTimeSecond) {
            result[i]?.let { id ->
                when (id) {
                    "1" -> a += 1
                    "2" -> b += 1
                }
            }

            if (a > b) {
                aWinTime += 1
            } else if (b > a) {
                bWinTime += 1
            }
        }

        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            writer.write("${secondToFormat(aWinTime)}\\n")
            writer.write("${secondToFormat(bWinTime)}\\n")
        }
    }

    private fun secondToFormat(totalSeconds: Int): String {
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        val timeFormatted = StringBuilder()
        if (minutes < 10) timeFormatted.append('0')
        timeFormatted.append(minutes)
        timeFormatted.append(':')
        if (seconds < 10) timeFormatted.append('0')
        timeFormatted.append(seconds)
        return timeFormatted.toString()
    }
}

```

## 3. 해석

### 1. **입력 파싱**:

- 각 득점 시각을 "분:초" 형식에서 초 단위로 변환하여 저장합니다.
- 예를 들어, "05:32"는 5 * 60 + 32 = 332초로 변환됩니다.

### 2. **리드 시간 계산**:

- 0초부터 2880초까지 각 초마다 리드한 팀을 확인합니다.
- 득점 시각에 따라 점수를 갱신하고, 리드한 팀의 시간을 증가시킵니다.
- 득점 기록을 바탕으로 각 팀의 점수를 계산하여 리드 시간을 구합니다.

### 3. **결과 출력**:

- 각 팀의 리드 시간을 "분:초" 형식으로 변환하여 출력합니다.
- 예를 들어, 332초는 "05:32"로 변환됩니다.

### 예시

1. 주어진 입력:

    ```
    5
    1 05:32
    2 10:23
    1 12:34
    2 25:45
    1 35:56
    
    ```

2. 리드 시간 계산:
   - 팀 1: 05:32 동안 리드
   - 팀 2: 25:23 동안 리드
3. 최종 출력:

    ```
    05:32
    25:23
    
    ```