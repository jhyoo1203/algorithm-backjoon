import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val m = readLine().toInt()
    val set = mutableSetOf<Int>()
    val sb = StringBuilder()

    repeat(m) {
        val st = StringTokenizer(readLine())
        val oper = st.nextToken()
        val num = if (st.hasMoreTokens()) st.nextToken().toInt() else 0

        when (oper) {
            "add" -> set.add(num)
            "remove" -> set.remove(num)
            "check" -> sb.append(if (set.contains(num)) 1 else 0).append("\n")
            "toggle" -> {
                if (set.contains(num)) {
                    set.remove(num)
                } else {
                    set.add(num)
                }
            }
            "all" -> repeat(21) { set.add(it) }
            "empty" -> set.clear()
        }
    }

    print(sb)
}
