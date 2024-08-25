package io.logantect.algorithms.grokkingalgorithms.chapter01

fun Array<Int>.binarySearch(item: Int): Int? {
    var min = 0
    var max = this.lastIndex
    while (min <= max) {
        val mid = (min + max) / 2
        val guess = this[mid]

        // 중간값이 찾고자 하는 값과 일치하면 해당 인덱스를 반환
        if (guess == item) {
            return mid
        }

        // 중간값이 찾고자 하는 값보다 크다면,
        // 찾고자 하는 값은 중간값의 왼쪽에 있으므로 검색 범위를 왼쪽으로 좁힌다.
        if (guess > item) {
            max = mid - 1
        } else {
            // 중간값이 찾고자 하는 값보다 작다면,
            // 찾고자 하는 값은 중간값의 오른쪽에 있으므로 검색 범위를 오른쪽으로 좁힌다.
            min = mid + 1
        }
    }

    // 찾고자 하는 값이 배열에 없으면 null을 반환
    return null
}

val sortedArray = Array(34) { it * 3 }

fun main(args: Array<String>) {
    println(sortedArray.binarySearch(9))
}
