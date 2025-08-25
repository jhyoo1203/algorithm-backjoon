fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val str = readLine()
    val q = readLine().toInt()

    repeat(q) {
        val (l, r) = readLine().split(" ").map { it.toInt() }

        val targetStr = str.substring(l - 1, r)

        var maxScore = 0
        val len = targetStr.length

        for (i in 1 until len) {
            val foldLen = minOf(i, len - i)
            var score = 0

            for (j in 0 until foldLen) {
                if (targetStr[i - 1 - j] == targetStr[i + j]) {
                    score++
                }

                if (score > maxScore) {
                    maxScore = score
                }
            }
        }

        println(maxScore)
    }
}
