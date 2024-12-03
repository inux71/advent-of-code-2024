fun main() {
    fun processInput(input: List<String>): String {
        var i = ""

        for (line in input) {
            i += line
        }

        return i
    }

    fun part1(input: List<String>): Int {
        val regex = Regex("mul\\((\\d+),(\\d+)\\)")

        val result = regex.findAll(processInput(input))

        var sum = 0

        result.forEach { r ->
            sum += (r.groupValues[1].toInt() * r.groupValues[2].toInt())
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        var processedInput: String = processInput(input)
        val regex = Regex("mul\\((\\d+),(\\d+)\\)")
        val dontRegex = Regex("don't\\([^)]*\\).*?(do\\(\\)|$)")

        processedInput = processedInput.replace(dontRegex, "")

        val result = regex.findAll(processedInput)

        var sum = 0

        result.forEach { r ->
            sum += (r.groupValues[1].toInt() * r.groupValues[2].toInt())
        }

        return sum
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}