fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val numbers = mutableListOf<Int>()
    val sb = StringBuilder()

    repeat(t) { numbers.add(readLine().toInt()) }

    val maxNum = numbers.max()
    val dp = IntArray(maxNum + 3)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..maxNum) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    numbers.forEach {
        sb.append(dp[it]).append("\n")
    }
    print(sb)
}
