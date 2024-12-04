import java.lang.StringBuilder

fun main() {
    fun part1(memories: List<String>): Int {
        var total = 0

        for (memory in memories) {
            val multiplyPattern = "(mul\\(\\d+,\\d+\\))".toRegex()
            val numbersPattern = "(\\d+)".toRegex()
            val matches = multiplyPattern.findAll(memory)

            for (match in matches) {
                val numbers = numbersPattern.findAll(match.value)
                    .map { it.value.toInt() }
                    .toList()

                if (numbers.size == 2) {
                    total += numbers[0] * numbers[1]
                }
            }
        }

        return total
    }

    fun part2(memory: String): Int {
        val multiplyPattern = "(mul\\(\\d+,\\d+\\))".toRegex()
        val numbersPattern = "(\\d+)".toRegex()

        val dontPattern = "(don't\\(\\))".toRegex()
        val doPattern = "(do\\(\\))".toRegex()

        var total = 0
        val updatedMemory = StringBuilder()
        val fragmentedMemory = memory.split(dontPattern)

        updatedMemory.append(fragmentedMemory[0])
        for (index in 1..<fragmentedMemory.size) {
            val validPieces = fragmentedMemory[index].split(doPattern)
            if (validPieces.size == 1) {
                continue
            }

            for (subIndex in 1..<validPieces.size) {
                updatedMemory.append(validPieces[subIndex])
            }
        }

        val matches = multiplyPattern.findAll(updatedMemory.toString())
        for (match in matches) {
            val numbers = numbersPattern.findAll(match.value)
                .map { it.value.toInt() }
                .toList()

            if (numbers.size == 2) {
                total += numbers[0] * numbers[1]
            }
        }

        return total
    }

    val input = readDay(3)

    val results = part1(input)
    println("All results of multiplications: $results")

    val doAndDontResults = part2(input.joinToString(""))
    println("All results of multiplications with do and don't: $doAndDontResults")

}