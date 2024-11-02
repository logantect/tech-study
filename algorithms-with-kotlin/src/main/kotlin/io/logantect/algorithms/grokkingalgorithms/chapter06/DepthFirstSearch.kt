package io.logantect.algorithms.grokkingalgorithms.chapter06

import java.util.ArrayDeque

private val graph = hashMapOf(
    "You" to listOf("Sergey", "Viktoria"),
    "Viktoria" to listOf("Sergey", "Vladimir"),
    "Vladimir" to listOf("Sergey", "Andrew", "Nikita", "Boris")
)

private fun depthFirstSearch(name: String) {
    val stack = ArrayDeque(graph[name]) // 초기 상태에서 "You"의 이웃을 스택에 추가
    val searched = mutableSetOf<String>() // 이미 검색된 노드를 저장하기 위한 집합

    while (stack.isNotEmpty()) {
        val person = stack.pop() // 스택에서 가장 위에 있는 노드를 꺼냄
        if (!searched.contains(person)) { // 아직 탐색하지 않은 노드인지 확인
            if (personIsSeller(person)) { // 목표 노드인지 확인
                println("$person is a mango seller!")
                return
            } else {
                graph[person]?.let { stack.addAll(it) } // 이웃 노드를 스택에 추가
                searched.add(person) // 탐색된 노드로 표시
            }
        }
    }
    println("No mango sellers found!")
}

private fun personIsSeller(name: String): Boolean = name.endsWith("s")

fun main(args: Array<String>) {
    depthFirstSearch("You")
}
