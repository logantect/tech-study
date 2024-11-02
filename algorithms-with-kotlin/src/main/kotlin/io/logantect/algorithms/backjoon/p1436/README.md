## [백준 1436번: 영화감독 숌](https://www.acmicpc.net/problem/1436)

### 요구사항
1. 종말의 수는 666이 포함된 수 이다.
2. 종말의 수가 포함된 N번째 영화 제목을 출력한다.
3. 제일 작은 종말의 수는 666이다.
4. 첫째 줄에 N이 주어지고, N은 10,000보다 작거나 같은 자연수이다.
5. 시간 제한: 2초, 메모리 제한: 128MB

### 풀이과정
1. 가장 작은 종말의 수는 666이기 때문에 이를 시작으로 숫자를 하나씩 증가시켜서 '666'이 포함된 숫자를 찾기로 했다.
2. '666'을 포함하는 숫자를 찾기 위해 모든 숫자를 하나씩 확인하는 방식인 [브루트 포스 검색](https://en.wikipedia.org/wiki/Brute-force_search) 방식을 사용하였다.
3. N이 최대 10,000이기 때문에, 이러한 브루트 포스 방식도 시간 내에 충분히 처리할 수 있었다.


### 코드
```kotlin
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    if (n > 10000) {
        throw IllegalArgumentException("Number is too big")
    }

    var movieNumber = 665
    var count = 0

    while (count < n) {
        movieNumber++
        if (movieNumber.toString().contains("666")) {
            count++
        }
    }
    println(movieNumber)
}
```