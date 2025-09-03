import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val people = Array(n) { 0 }
    var count = 0

    while (st.hasMoreTokens()) {
        people[count++] = st.nextToken().toInt()
    }

    people.sort()

    val dp = Array(n) { 0 }
    dp[0] = people.first()
    var result = people.first()

    for (i in 1 until n) {
        dp[i] = dp[i - 1] + people[i]
        result += dp[i]
    }

    print(result)
}
