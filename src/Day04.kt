fun main() {
    fun part1(input: List<String>): Int {
        var counter = 0
        val xmas = "XMAS"

        for (y in input.indices) {
            for (x in input[y].indices) {
                if (input[y][x] == 'X') {
                    // top
                    if (y - xmas.length + 1 >= 0 &&
                        input[y - 1][x] == 'M' &&
                        input[y - 2][x] == 'A' &&
                        input[y - 3][x] == 'S') {
                        counter++
                    }

                    // top-right
                    if (y - xmas.length + 1 >= 0 &&
                        x + xmas.length - 1 < input[y].length &&
                        input[y - 1][x + 1] == 'M' &&
                        input[y - 2][x + 2] == 'A' &&
                        input[y - 3][x + 3] == 'S') {
                        counter++
                    }

                    // right
                    if (x + xmas.length - 1 < input[y].length &&
                        input[y][x + 1] == 'M' &&
                        input[y][x + 2] == 'A' &&
                        input[y][x + 3] == 'S') {
                        counter++
                    }

                    // bottom-right
                    if (y + xmas.length - 1 < input.size &&
                        x + xmas.length - 1 < input[y].length &&
                        input[y + 1][x + 1] == 'M' &&
                        input[y + 2][x + 2] == 'A' &&
                        input[y + 3][x + 3] == 'S') {
                        counter++
                    }

                    // bottom
                    if (y + xmas.length - 1 < input.size &&
                        input[y + 1][x] == 'M' &&
                        input[y + 2][x] == 'A' &&
                        input[y + 3][x] == 'S') {
                        counter++
                    }

                    // bottom-left
                    if (y + xmas.length - 1 < input.size &&
                        x - xmas.length + 1 >= 0 &&
                        input[y + 1][x - 1] == 'M' &&
                        input[y + 2][x - 2] == 'A' &&
                        input[y + 3][x - 3] == 'S') {
                        counter++
                    }

                    // left
                    if (x - xmas.length + 1 >= 0 &&
                        input[y][x - 1] == 'M' &&
                        input[y][x - 2] == 'A' &&
                        input[y][x - 3] == 'S') {
                        counter++
                    }

                    // top-left
                    if (y - xmas.length + 1 >= 0 &&
                        x - xmas.length + 1 >= 0 &&
                        input[y - 1][x - 1] == 'M' &&
                        input[y - 2][x - 2] == 'A' &&
                        input[y - 3][x - 3] == 'S') {
                        counter++
                    }
                }
            }
        }

        return counter
    }

    fun part2(input: List<String>): Int {
        var counter = 0

        for (y in 1..input.size - 2) {
            for (x in 1..input[y].length - 2) {
                if (input[y][x] == 'A') {
                    if ((input[y - 1][x - 1] == 'M' && input[y + 1][x + 1] == 'S' || input[y - 1][x - 1] == 'S' && input[y + 1][x + 1] == 'M') &&
                        (input[y - 1][x + 1] == 'M' && input[y + 1][x - 1] == 'S' || input[y - 1][x + 1] == 'S' && input[y + 1][x - 1] == 'M')) {
                        counter++
                    }
                }
            }
        }

        return counter
    }

    val input: List<String> = readInput("Day04")
    part1(input).println()
    part2(input).println()
}