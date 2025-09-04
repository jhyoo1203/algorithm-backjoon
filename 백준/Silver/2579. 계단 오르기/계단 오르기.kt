fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val points = IntArray(n + 1)

    for (i in 1..n) { points[i] = readLine().toInt() }

    val dp = IntArray(n + 1)
    dp[1] = points[1]
    if (n >= 2) dp[2] = points[1] + points[2]
    if (n >= 3) dp[3] = maxOf(points[1] + points[3], points[2] + points[3])

    for (i in 4..n) {
        dp[i] = maxOf(
            dp[i - 2] + points[i],
            dp[i - 3] + points[i - 1] + points[i]
        )
    }

    print(dp[n])
}
