fun main() {
    fun part1(sides: List<Pair<Int, Int>>): Int {
        val leftSide = mutableListOf<Int>()
        val rightSide = mutableListOf<Int>()

        sides.forEach {
            leftSide.add(it.first)
            rightSide.add(it.second)
        }

        leftSide.sort()
        rightSide.sort()

        var totalDistance = 0
        for (index in leftSide.indices) {
            val (smaller, bigger) = minMax(leftSide[index], rightSide[index])
            totalDistance += bigger - smaller
        }
        return totalDistance
    }

    fun part2(sides: List<Pair<Int, Int>>): Int {
        val leftSide = mutableListOf<Int>()
        val occurrences = mutableMapOf<Int, Int>()

        sides.forEach {
            leftSide.add(it.first)
            occurrences.compute(it.second) { _, v -> (v ?: 0) + 1 }
        }

        return leftSide.sumOf { it * occurrences.getOrDefault(it, 0) }
    }

    val sides = readDay(1)
        .map { it.split("   ") }
        .map { it[0].toInt() to it[1].toInt() }

    val totalDistance = part1(sides)
    println("Total Distance: $totalDistance")

    val similarityScore = part2(sides)
    println("Similarity Score: $similarityScore")
}