package com.matthias.aoc.y2022

import com.matthias.aoc.downloadAocInputFileIfMissing
import com.matthias.aoc.readAocInputFile
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day5Test {

    val day5 = Day5()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2022, 5)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2022, 5, "part-1-test").readText()

        val output: String = day5.solvePart1(input)

        assertEquals("CMZ", output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2022, 5, "full").readText()

        val output: String = day5.solvePart1(input)

        assertEquals("SBPQRSCDF", output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2022, 5, "part-2-test").readText()

        val output: String = day5.solvePart2(input)

        assertEquals("MCD", output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2022, 5, "full").readText()

        val output: String = day5.solvePart2(input)

        assertEquals("RGLVRCQSB", output)
    }
}