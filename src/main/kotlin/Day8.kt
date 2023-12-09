internal class Day8 {

    fun solvePart1(input: String): Int {
        val (moves, networkInput) = input.split("\n\n")
        val network = parseNetwork(networkInput)

        return solve(moves, network, FIRST_NODE) { it == LAST_NODE }
    }

    fun solvePart2(input: String): Long {
        val (moves, networkInput) = input.split("\n\n")
        val network = parseNetwork(networkInput)

        return network.keys
            .filter { it.last() == STARTING }
            .map { solve(moves, network, it) { it.last() == ENDING }.toLong() }
            .reduce { first, second -> lcm(first, second) }
    }

    fun solve(moves: String, network: Map<String, Pair<String, String>>, firstNode: String, lastNode: (String) -> Boolean): Int {
        var step = 0
        var currentNode = firstNode

        while (!lastNode(currentNode)) {
            val move = moves[step % moves.length]
            val passage = network[currentNode] ?: error("No mapping for $currentNode")
            currentNode = if (move == LEFT) passage.first else passage.second
            step++
        }

        return step
    }

    fun ncd(number1: Long, number2: Long): Long {
        var a = number1
        var b = number2
        while (b != 0L) {
            val t = b
            b = a % b
            a = t
        }
        return a
    }

    fun lcm(number1: Long, number2: Long): Long {
        return (number1 * number2) / ncd(number1, number2)
    }

    fun parseNetwork(input: String): Map<String, Pair<String, String>> = input.lineSequence()
        .map { "\\w+".toRegex().findAll(it).map { it.value }.toList() }
        .associate { (node, left, right) -> node to (left to right) }

    companion object {
        const val FIRST_NODE = "AAA"
        const val LAST_NODE = "ZZZ"
        const val LEFT = 'L'
        const val RIGHT = 'R'
        const val STARTING = 'A'
        const val ENDING = 'Z'
    }
}