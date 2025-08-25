fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val words = mutableSetOf<String>()

    repeat(n) { 
        words.add(readLine()) 
    }

    val sortedWords = words.sortedWith(compareBy<String> { it.length }.thenBy { it })

    println(sortedWords.joinToString("\n"))
}
