import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val points = Array(n) {
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        x to y
    }

    points.sortWith(compareBy({ it.first }, { it.second }))

    val sb = StringBuilder()
    for ((x, y) in points) {
        sb.append("$x $y\n")
    }
    println(sb)
}
