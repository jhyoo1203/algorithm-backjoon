import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val map = mutableMapOf<String, String>()
    val sb = StringBuilder()

    repeat(n) {
        st = StringTokenizer(readLine())
        map[st.nextToken()] = st.nextToken()
    }

    repeat(m) {
        sb.append(map[readLine()]).append("\n")
    }

    print(sb)
}
