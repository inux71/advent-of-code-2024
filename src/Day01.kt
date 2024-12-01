import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val left: MutableList<Int> = mutableListOf()
        val right: MutableList<Int> = mutableListOf()

        input.forEach { pair: String ->
            val splitted: List<String> = pair.split("   ")

            left.add(splitted[0].toInt())
            right.add(splitted[1].toInt())
        }

        var distance = 0

        while (left.isNotEmpty()) {
            val maxLeft: Int = left.max()
            left.remove(maxLeft)

            val maxRight: Int = right.max()
            right.remove(maxRight)

            distance += abs(maxLeft - maxRight)
        }

        return distance
    }

    fun part2(input: List<String>): Int {
        val left: MutableList<Int> = mutableListOf()
        val right: MutableList<Int> = mutableListOf()

        input.forEach { pair: String ->
            val splitted: List<String> = pair.split("   ")

            left.add(splitted[0].toInt())
            right.add(splitted[1].toInt())
        }

        var score = 0
        val s: Map<Int, Int> = right.groupingBy { it }.eachCount()

        for (l in left) {
            score += l * s.getOrDefault(l, 0)
        }

        return score
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
