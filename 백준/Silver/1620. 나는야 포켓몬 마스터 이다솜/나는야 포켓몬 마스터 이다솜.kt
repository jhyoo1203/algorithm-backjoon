import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val map = mutableMapOf<String,Int>()
    val arr = Array(n + 1) { "" }
    val sb = StringBuilder()

    repeat(n) { i ->
        val pocketMon = readLine()
        map[pocketMon] = i + 1
        arr[i + 1] = pocketMon
    }

    repeat(m) {
        val query = readLine()
        if (query[0].isDigit()) {
            sb.append(arr[query.toInt()]).append("\n")
        } else {
            sb.append(map[query]).append("\n")
        }
    }

    print(sb)
}
