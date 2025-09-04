import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val map = mutableMapOf<String, Int>()

        repeat(readLine().toInt()) {
            val st = StringTokenizer(readLine())
            val name = st.nextToken()
            val type = st.nextToken()

            map.merge(type, 1) { old, new -> old + new }
        }

        var result = 1
        map.values.forEach { result *= (it + 1) }

        sb.appendLine(result - 1)
    }

    print(sb)
}
