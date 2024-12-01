import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.math.max
import kotlin.math.min

/**
 * Shortcut for readInput that formats a day to file name for input.
 */
fun readDay(day: Int) = readInput("Day${day.toString().padStart(2, '0')}")

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