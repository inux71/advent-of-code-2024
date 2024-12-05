fun main() {
    fun processInput(input: List<String>): List<List<List<Int>>> {
        val rules = mutableListOf<List<Int>>()
        val updates = mutableListOf<List<Int>>()

        var i = 0
        for (line in input) {
            i++

            if (line.isBlank()) {
                break
            }

            val rule: List<Int> = line.split("|")
                .map { it.toInt() }
            rules.add(rule)
        }

        for (j in i..<input.size) {
            val update: List<Int> = input[j].split(",")
                .map { it.toInt() }
            updates.add(update)
        }

        return listOf(rules, updates)
    }

    fun fixUpdate(rules: List<List<Int>>, update: MutableList<Int>): List<Int> {
        var i = 0
        while (i <= update.size - 2) {
            if (listOf(update[i], update[i + 1]) !in rules) {
                val temp = update[i]
                update[i] = update[i + 1]
                update[i + 1] = temp

                i = -1
            }

            i++
        }

        return update
    }

    fun part1(rules: List<List<Int>>, updates: List<List<Int>>): Int {
        var sum = 0

        for (update in updates) {
            var incorrect = false

            for (i in 0..update.size - 2) {
                if (listOf(update[i], update[i + 1]) !in rules) {
                    incorrect = true
                    break
                }
            }

            if (!incorrect) {
                sum += update[update.size / 2]
            }
        }

        return sum
    }

    fun part2(rules: List<List<Int>>, updates: List<List<Int>>): Int {
        val incorrectUpdates: MutableList<List<Int>> = mutableListOf()
        var sum = 0

        for (update in updates) {
            for (i in 0..update.size - 2) {
                if (listOf(update[i], update[i + 1]) !in rules) {
                    incorrectUpdates.add(update)
                    break
                }
            }
        }

        for (i in 0..<incorrectUpdates.size) {
            incorrectUpdates[i] = fixUpdate(rules, incorrectUpdates[i].toMutableList())
            sum += incorrectUpdates[i][incorrectUpdates[i].size / 2]
        }

        return sum
    }

    val input: List<String> = readInput("Day05")

    val processedInput: List<List<List<Int>>> = processInput(input)

    part1(processedInput[0], processedInput[1]).println()
    part2(processedInput[0], processedInput[1]).println()
}
