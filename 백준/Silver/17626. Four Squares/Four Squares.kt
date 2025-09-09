fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1

    for (i in 2..n) {
        dp[i] = dp[i- 1]

        var j = 1
        while (j * j <= i) {
            dp[i] = minOf(dp[i], dp[i - j * j])
            j++
        }
        dp[i]++
    }

    println(dp[n])
}
