# [백준 2003번: 수들의 합 2](https://www.acmicpc.net/problem/2003)

## 1. 문제 설명

### 개요:
주어진 배열에서 연속된 부분 배열의 합이 특정 값 `m`이 되는 경우의 수를 찾는 문제다. 예를 들어, 배열 `[1, 2, 3, 2, 1]`에서 합이 `5`가 되는 부분 배열은 `[2, 3]`과 `[3, 2]` 두 개가 존재한다.

### 목표:
배열의 각 원소가 주어졌을 때, 연속된 부분 배열의 합이 `m`이 되는 모든 경우의 수를 출력하는 것이 목표이다.

### 제한 조건:
- 배열의 길이 `n`은 최대 10,000이다.
- 목표 합 `m`은 최대 300,000,000이다.
- 배열의 각 원소는 30,000을 넘지 않는 자연수이다.

### 입력:
- 첫 줄에 두 정수 `n`(배열의 길이)과 `m`(찾고자 하는 부분 배열의 합)이 주어진다.
- 두 번째 줄에 배열 `numbers`가 주어진다.

### 출력:
- 부분 배열의 합이 `m`인 경우의 수를 출력한다.

## 2. 알고리즘 설계

### 문제 해결 전략:
이 문제는 슬라이딩 윈도우(Sliding Window) 알고리즘을 사용하여 해결한다. 슬라이딩 윈도우 방식은 배열을 한 번만 순회하며 부분 배열의 합을 계산하므로, 시간 효율성이 매우 뛰어나다.

### 알고리즘 단계:

1. **변수 초기화**:
   - `sum`을 0으로 초기화하고, 배열의 시작 인덱스 `left`를 0으로 설정한다.
   - 부분 배열의 합이 `m`이 되는 경우의 수를 저장할 `count` 변수를 0으로 설정한다.

2. **배열 순회**:
   - 배열의 끝 인덱스 `right`를 증가시키며 현재 위치의 값을 `sum`에 더한다.
   - 만약 `sum`이 `m`보다 크다면, 시작 인덱스 `left`를 오른쪽으로 이동시켜 `sum`을 줄인다.
   - `sum`이 `m`과 같아지면, `count`를 증가시킨다.

3. **최종 결과 출력**:
   - 배열 전체를 순회한 후, `count`에 저장된 값을 출력한다. 이 값은 부분 배열의 합이 `m`인 모든 경우의 수이다.

### 시간 복잡도:
- 배열을 한 번만 순회하므로 시간 복잡도는 `O(n)`이다.

### 공간 복잡도:
- 입력 배열 외에는 추가적인 공간이 거의 필요 없으므로 공간 복잡도는 `O(1)`이다.

## 3. 코드 구현:

```kotlin
fun main() = with(System.`in`.bufferedReader()) {
    val firstLine = readLine()
    val stringTokenizer = StringTokenizer(firstLine)
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val stringTokenizer2 = StringTokenizer(readLine())
    val numbers = IntArray(n) { stringTokenizer2.nextToken().toInt() }

    println(SumOfNumbers2.solution(n, m, numbers))
}

object SumOfNumbers2 {
    fun solution(n: Int, m: Int, numbers: IntArray): Int {
        var count = 0
        var sum = 0
        var left = 0

        for (right in 0 until n) {
            sum += numbers[right]

            while (sum > m) {
                sum -= numbers[left]
                left++
            }

            if (sum == m) {
                count++
            }
        }
        return count
    }
}
```

## 4. 해석 및 예시

### 알고리즘 분석:
이 코드는 슬라이딩 윈도우와 투 포인터 기법을 사용하여 배열을 순회하면서 부분 배열의 합이 `m`과 같은 경우를 찾는다. `sum`이 `m`보다 크면 시작 인덱스 `left`를 이동시키며 `sum`을 줄이고, `sum`이 `m`과 같아지면 `count`를 증가시킨다.

### 예시:

배열이 `[1, 2, 3, 2, 1]`이고 `m = 5`일 때:

1. **초기 상태**:
   - `left = 0`, `sum = 0`, `count = 0`
   - 배열: `[1, 2, 3, 2, 1]`

2. **첫 번째 반복 (`right = 0`)**:
   - `numbers[0] = 1`을 `sum`에 더한다.
   - `sum = 1` (m보다 작음)
   - 조정 필요 없음, 다음 요소로 이동.

```plaintext
  [1]  2   3   2   1
   ^
   left,right
```

3. **두 번째 반복 (`right = 1`)**:
   - `numbers[1] = 2`를 `sum`에 더한다.
   - `sum = 3` (여전히 m보다 작음)
   - 조정 필요 없음, 다음 요소로 이동.

```plaintext
  [1   2]  3   2   1
   ^   ^
   left right
```

4. **세 번째 반복 (`right = 2`)**:
   - `numbers[2] = 3`을 `sum`에 더한다.
   - `sum = 6` (m보다 큼), 그래서 시작 인덱스 `left`를 이동시켜 `numbers[left]`를 빼서 합을 줄인다.
   - `left = 1`로 이동하고 `numbers[0]`을 빼면 `sum = 5`가 된다.
   - `sum == m`이므로 `count`를 증가시킨다.

```plaintext
  1  [2   3]  2   1
      ^   ^
     left right
```

5. **네 번째 반복 (`right = 3`)**:
   - `numbers[3] = 2`를 `sum`에 더한다.
   - `sum = 7` (m보다 큼), 그래서 시작 인덱스 `left`를 이동시켜 합을 줄인다.
   - `left = 2`로 이동하고 `numbers[1]`을 빼면 `sum = 5`가 된다.
   - `sum == m`이므로 `count`를 증가시킨다.

```plaintext
  1   2  [3   2]  1
          ^   ^
         left right
```

6. **다섯 번째 반복 (`right = 4`)**:
   - `numbers[4] = 1`을 `sum`에 더한다.
   - `sum = 6` (m보다 큼), 그래서 시작 인덱스 `left`를 이동시켜 합을 줄인다.
   - `left = 3`로 이동하고 `numbers[2]`를 빼면 `sum = 3` (m보다 작음).
   - 여기서는 유효한 부분 배열이 없다.

```plaintext
  1   2   3  [2   1]
              ^   ^
             left right
```

### 최종 상태:
- 합이 `m`인 부분 배열의 총 개수는 `2`이다.

### 결론:
이 알고리즘은 배열을 한 번만 순회하면서 효율적으로 문제를 해결한다. 시간 복잡도 `O(n)`으로 제약 조건 내에서 충분히 빠르게 동작한다.
