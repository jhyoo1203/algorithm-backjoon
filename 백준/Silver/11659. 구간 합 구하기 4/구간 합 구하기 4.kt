import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val numbers = IntArray(n + 1)
    var idx = 1

    readLine().split(" ").forEach { numbers[idx++] = it.toInt() }

    val dp = IntArray(n + 1)
    dp[1] = numbers[1]

    for (i in 2 until numbers.size) {
        dp[i] = numbers[i] + dp[i - 1]
    }

    val sb = StringBuilder()

    repeat(m) {
        st = StringTokenizer(readLine())
        val i = st.nextToken().toInt()
        val j = st.nextToken().toInt()

        sb.appendLine(dp[j] - dp[i - 1])
    }

    print(sb)
}
