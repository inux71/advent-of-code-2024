enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

fun main() {
    fun getStartingPosition(input: List<List<Char>>): Pair<Int, Int> {
        for (y in input.indices) {
            for (x in input[y].indices) {
                if (input[y][x] == '^') {
                    return Pair(x, y)
                }
            }
        }

        return Pair(0, 0)
    }

    fun part1(input: MutableList<MutableList<Char>>, startingPosition: Pair<Int, Int>): Int {
        var x: Int = startingPosition.first
        var y: Int = startingPosition.second
        var direction: Direction = Direction.NORTH

        while (true) {
            when (direction) {
                Direction.NORTH -> {
                    if (y < 0) {
                        break
                    }

                    if (input[y][x] == '#') {
                        direction = Direction.EAST
                        x++
                        y++
                    } else {
                        input[y][x] = 'X'
                        y--
                    }
                }
                Direction.EAST -> {
                    if (x >= input[y].size) {
                        break
                    }

                    if (input[y][x] == '#') {
                        direction = Direction.SOUTH
                        x--
                        y++
                    } else {
                        input[y][x] = 'X'
                        x++
                    }
                }
                Direction.SOUTH -> {
                    if (y >= input.size) {
                        break
                    }

                    if (input[y][x] == '#') {
                        direction = Direction.WEST
                        x--
                        y--
                    } else {
                        input[y][x] = 'X'
                        y++
                    }
                }
                Direction.WEST -> {
                    if (x < 0) {
                        break
                    }

                    if (input[y][x] == '#') {
                        direction = Direction.NORTH
                        x++
                        y--
                    } else {
                        input[y][x] = 'X'
                        x--
                    }
                }
            }
        }

        var positions = 0

        for (line in input) {
            positions += line.count { it == 'X' }
        }

        return positions
    }

    fun part2(input: MutableList<MutableList<Char>>, startingPosition: Pair<Int, Int>): Int {
        return 0
    }

    val input: List<String> = readInput("Day06_test")
    val startingPosition: Pair<Int, Int> = getStartingPosition(input.map { it.toList() })

    part1(input.map { it.toMutableList() }.toMutableList(), startingPosition).println()
    part2(input.map { it.toMutableList() }.toMutableList(), startingPosition).println()
}
