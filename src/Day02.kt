fun main() {
    fun isSafe(report: List<Int>): Boolean {
        val increasing: Boolean = report[0] - report[1] < 0

        for (i in 0..<report.size - 1) {
            when (increasing) {
                true -> {
                    if (report[i] - report[i + 1] !in -3..-1) {
                        return false
                    }
                }
                false -> {
                    if (report[i] - report[i + 1] !in 1..3) {
                        return false
                    }
                }
            }
        }

        return true
    }

    fun part1(input: List<String>): Int {
        val reports: MutableList<List<Int>> = mutableListOf()

        input.forEach { line: String ->
            val report: List<Int> = line.split(" ")
                .map { it.toInt() }

            reports.add(report)
        }

        var safeReports = 0

        for (i in 0..<reports.size) {
            if (isSafe(reports[i])) {
                safeReports++
            }
        }

        return safeReports
    }

    fun part2(input: List<String>): Int {
        val reports: MutableList<MutableList<Int>> = mutableListOf()

        input.forEach { line: String ->
            val report: List<Int> = line.split(" ")
                .map { it.toInt() }

            reports.add(report.toMutableList())
        }

        var safeReports = 0

        for (i in 0..<reports.size) {
            if (isSafe(reports[i])) {
                safeReports++
            } else {
                for (j in 0..<reports[i].size) {
                    val removed: Int = reports[i].removeAt(j)

                    if (isSafe(reports[i])) {
                        safeReports++
                        break
                    }

                    reports[i].add(j, removed)
                }
            }
        }

        return safeReports
    }

    val input: List<String> = readInput("Day02")
    part1(input).println()
    part2(input).println()
}