fun main() {
    fun part1(reports: List<List<Int>>): Int {
        return reports.count { report ->
            var increase = true
            var lastLevel = -1

            report.forEachIndexed { index, level ->
                if (index == 0) {
                    lastLevel = level
                    return@forEachIndexed
                } else if (index == 1) {
                    if (level < lastLevel) {
                        increase = false
                    }
                }

                if (lastLevel == level) {
                    return@count false
                } else if (increase && (level < lastLevel || level - lastLevel > 3)) {
                    return@count false
                } else if (!increase && (level > lastLevel || lastLevel - level > 3)) {
                    return@count false
                }

                lastLevel = level
            }

            true
        }
    }

    fun part2(): Int {
        TODO("Do part two.")
    }

    val reports = readDay(2)
        .map { it.split(" ").map { level -> level.toInt() } }

    val safeReports = part1(reports)
    println("Safe Reports: $safeReports")
}