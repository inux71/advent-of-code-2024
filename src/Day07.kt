fun main() {
    fun getResults(value: Long, index: Int, values: List<Long>): List<Long> {
        if (index == values.size) {
            return listOf(value)
        }

        return getResults(value * values[index], index + 1, values) +
                getResults(value + values[index], index + 1, values) +
                // this is for part 2
                getResults((value.toString() + values[index].toString()).toLong(), index + 1, values)
    }

    fun part12(input: List<String>): Long {
        var sum = 0L

        for (equation in input) {
            val splitted: List<String> = equation.split(':')
            val testValue: Long = splitted[0].toLong()
            val values: List<Long> = splitted[1].trim()
                .split(' ')
                .map { it.toLong() }
            val results: List<Long> = getResults(values[0], 1, values)

            if (testValue in results) {
                sum += testValue
            }
        }

        return sum
    }

    val input: List<String> = readInput("Day07")

    part12(input).println()
}
