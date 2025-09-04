fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val numbers = mutableListOf<Int>()

    repeat(readLine().toInt()) {
        numbers.add(readLine().toInt())
    }

    val maxNum = numbers.max()
    val dp = LongArray(maxNum + 3)
    dp[0] = 1L
    dp[1] = 1L
    dp[2] = 1L

    for (i in 3..maxNum) {
        dp[i] = dp[i - 2] + dp[i - 3]
    }

    numbers.forEach {
        sb.appendLine(dp[it - 1])
    }

    print(sb)
}
