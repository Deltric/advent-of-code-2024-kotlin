fun main(args: Array<String>) {
    val sampleMode = args.contains("sampleMode")

    fun checkReport(report: List<Int>): Boolean {
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

            val invalid = if (lastLevel == level) {
                true
            } else if (increase && (level < lastLevel || level - lastLevel > 3)) {
                true
            } else if (!increase && (level > lastLevel || lastLevel - level > 3)) {
                true
            } else {
                false
            }

            if (invalid) {
                return false
            }
            lastLevel = level
        }

        return true
    }

    fun part1(reports: List<List<Int>>): Int {
        return reports.count(::checkReport)
    }

    fun part2(reports: List<List<Int>>): Int {
        return reports.count { report ->
            if (checkReport(report)) {
                return@count true
            }

            report.forEachIndexed { index, i ->
                val modified = report.toMutableList()
                modified.removeAt(index)

                if (checkReport(modified)) {
                    return@count true
                }
            }

            return@count false
        }
    }

    val reports = readDay(2, sampleMode)
        .map { it.split(" ").map { level -> level.toInt() } }

    val safeReports = part1(reports)
    println("Safe Reports: $safeReports")

    val problemDampenedSafeReports = part2(reports)
    println("Problem Dampened Safe Reports: $problemDampenedSafeReports")
}