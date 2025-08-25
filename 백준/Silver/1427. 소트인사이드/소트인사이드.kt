fun main() = with(System.`in`.bufferedReader()) {
    val numbers = readLine()

    val result = numbers.toCharArray()
        .sortedDescending()
        .joinToString("")

    println(result)
}
