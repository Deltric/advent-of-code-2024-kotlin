import kotlin.math.max
import kotlin.math.min

fun main() {
    fun part1(input: List<String>): Int {
        val leftSide = mutableListOf<Int>()
        val rightSide = mutableListOf<Int>()

        input.map { it.split("   ") }
            .forEach {
                leftSide.add(it[0].toInt())
                rightSide.add(it[1].toInt())
            }

        leftSide.sort()
        rightSide.sort()

        var totalDistance = 0
        for (index in leftSide.indices) {
            val smallerNumber = min(leftSide[index], rightSide[index])
            val biggerNumber = max(leftSide[index], rightSide[index])
            totalDistance += biggerNumber - smallerNumber
        }
        return totalDistance
    }

    fun part2(input: List<String>): Int {
        val leftSide = mutableListOf<Int>()
        val occurrences = mutableMapOf<Int, Int>()

        input.map { it.split("   ") }
            .forEach {
                leftSide.add(it[0].toInt())
                val rightNumber = it[1].toInt()
                occurrences[rightNumber] = occurrences.getOrDefault(rightNumber, 0) + 1
            }

        return leftSide.sumOf { it * occurrences.getOrDefault(it, 0) }
    }

    val dayOneInput = readDay(1)
    val part1Result = part1(dayOneInput)
    println("Total Distance: $part1Result")

    val part2Result = part2(dayOneInput)
    println("Similarity Score: $part2Result")
}