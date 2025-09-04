fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val numbers = mutableListOf<Int>()
    val sb = StringBuilder()

    repeat(t) { numbers.add(readLine().toInt()) }

    val maxNum = numbers.max()
    val dp = Array(maxNum + 2) { 0 }
    dp[0] = 0
    dp[1] = 1

    for (i in 2..maxNum) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    numbers.forEach {
        if (it == 0) {
            sb.append("1 0\n")
        } else {
            sb.append(dp[it - 1]).append(" ").append(dp[it]).append("\n")
        }
    }
    print(sb)
}
