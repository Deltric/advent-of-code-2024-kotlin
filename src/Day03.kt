fun main(args: Array<String>) {
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

    fun part2(): Int {
        TODO("Implement part 2")
    }

    val input = readDay(3)
    val results = part1(input)
    println("All results of multiplications: $results")
}