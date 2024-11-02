package io.logantect.algorithms.grokkingalgorithms.chapter02

fun Array<Int>.selectionSort(): Array<Int> {
    for (i in this.indices) {
        val smallestIndex = this.getSmallest(i)
        if (i != smallestIndex) {
            val temp = this[i]
            this[i] = this[smallestIndex]
            this[smallestIndex] = temp
        }
    }
    return this
}

fun Array<Int>.getSmallest(startIndex: Int): Int {
    var smallestIndex = startIndex
    for (i in startIndex + 1 until this.size) {
        if (this[i] < this[smallestIndex]) {
            smallestIndex = i
        }
    }
    return smallestIndex
}

fun main(args: Array<String>) {
    val array = arrayOf(0, 2, 5, 1, 8, 23, 31, 21, 93, 213, 31, 11, 1512, 231, 341, 516, 132, 322, 421, 643)
    println("sort: ${array.selectionSort().joinToString(", ")}")
}