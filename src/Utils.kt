import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

fun readDay(day: Int) = readInput("Day${day.toString().padStart(2, '0')}")

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("./input/$name.txt").readText().trim().lines()