package io.logantect.algorithms._inbox

interface KnightTour {
    fun solution(positions: List<String>): String

    companion object {
        const val VALID = "Valid"
        const val INVALID = "Invalid"
    }
}

class KnightTourSolution01 : KnightTour {
    override fun solution(positions: List<String>): String {
        // 1. 좌표로 변환 한다.
        val coordinates: List<Pair<Int, Int>> = positions.map {
            Pair(it[0] - 'A', it[1].toString().toInt() - 1)
        }

        // 2. 이미 이동한 곳인지 검증한다.
        val visited = mutableSetOf<Pair<Int, Int>>()
        for (i in coordinates.indices) {
            if (coordinates[i] in visited) return KnightTour.INVALID
            visited.add(coordinates[i])
            if (i < 1) {
                continue
            }

            println("prev: ${coordinates[i - 1]}, current: ${coordinates[i]}")
            // 3. 나이트가 이동한 경로가 가능한지 검증한다.
            if (!isValidMove(coordinates[i - 1], coordinates[i])) {
                return KnightTour.INVALID
            }
        }
        // 4. 첫번쨰 곳으로 다시 돌아갈 수 있는지 검증한다.
        return if (isValidMove(coordinates.last(), coordinates.first())) "Valid" else "Invalid"
    }

    private fun isValidMove(start: Pair<Int, Int>, end: Pair<Int, Int>): Boolean {
        val moves = listOf(
            Pair(2, 1), Pair(1, 2), Pair(-1, 2), Pair(-2, 1),
            Pair(-2, -1), Pair(-1, -2), Pair(1, -2), Pair(2, -1)
        )
        return moves.any { move ->
            Pair(start.first + move.first, start.second + move.second) == end
        }
    }

}