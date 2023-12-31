import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day3Test {

    private val day3 = Day3()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-3/part-1-test").readText()

        val output = day3.solvePart1(input)

        assertEquals(4361, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-3/full").readText()

        val output = day3.solvePart1(input)

        assertEquals(530495, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-3/part-2-test").readText()

        val output = day3.solvePart2(input)

        assertEquals(467835, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-3/full").readText()

        val output = day3.solvePart2(input)

        assertEquals(80253814, output)
    }
}