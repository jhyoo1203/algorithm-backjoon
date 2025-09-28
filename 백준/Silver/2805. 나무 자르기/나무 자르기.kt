import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toLong()

    val trees = readLine().split(" ")
        .map { it.toLong() }
        .toLongArray()

    var min = 0L
    var max = trees.max()

    while (min <= max) {
        val mid = (min + max) / 2
        var mine = 0L
        trees.forEach { if (it > mid) mine += it - mid }

        if (mine >= m) {
            min = mid + 1
        } else {
            max = mid - 1
        }
    }

    print(max)
}
