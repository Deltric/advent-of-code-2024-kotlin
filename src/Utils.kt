import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.math.max
import kotlin.math.min

/**
 * Shortcut for readInput that formats a day to file name for input.
 */
fun readDay(day: Int, sampleMode: Boolean = false): List<String> {
    var fileName = "Day${day.toString().padStart(2, '0')}"
    if (sampleMode) {
        fileName = "${fileName}_Sample"
    }
    return readInput(fileName)
}

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("./input/$name.txt").readText().trim().lines()

/**
 * Helper for min maxing two numbers.
 * @return First number is the minimum, second number is maximum.
 */
fun minMax(a: Int, b: Int): Pair<Int, Int> {
    return min(a, b) to max(a, b)
}

/**
 * Love child of forEachIndexed and sumOf
 */
inline fun <T> Iterable<T>.sumOfIndexed(selector: (Int, T) -> Int): Int {
    var index = 0
    var sum = 0
    for (element in this) {
        sum += selector(index++, element)
    }
    return sum
}