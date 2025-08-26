fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val set = mutableSetOf<String>()

    for (i in s.indices) {
        for (j in i + 1..s.length) {
            set.add(s.substring(i, j))
        }
    }

    print(set.size)
}