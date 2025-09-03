import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    var k = st.nextToken().toInt()
    val coins = mutableListOf<Int>()
    var count = 0

    repeat(n) {
        coins.add(readLine().toInt())
    }

    coins.reverse()

    coins.forEach { coin ->
        if (coin <= k) {
            while (coin <= k) {
                k -= coin
                count++
            }
        }
    }

    print(count)
}
