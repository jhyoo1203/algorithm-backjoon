fun main() = with(System.`in`.bufferedReader()) {
    val query = readLine()

    val numberGroups = query.split("-")

    var result = numberGroups[0].split("+").sumOf { it.toInt() }

    for (i in 1 until numberGroups.size) {
        val groupSum = numberGroups[i].split("+").sumOf { it.toInt() }
        result -= groupSum
    }

    println(result)
}
