import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    val arr = Array(n) { IntArray(m) }

    var minH = Int.MAX_VALUE
    var maxH = Int.MIN_VALUE

    repeat(n) { i ->
        val line = StringTokenizer(readLine())
        for (j in 0 until m) {
            val h = line.nextToken().toInt()
            arr[i][j] = h
            minH = minOf(minH, h)
            maxH = maxOf(maxH, h)
        }
    }

    var bestTime = Int.MAX_VALUE
    var bestHeight = 0

    for (target in minH..maxH) {
        var time = 0
        var blocks = b

        for (i in 0 until n) {
            for (j in 0 until m) {
                val diff = arr[i][j] - target
                if (diff > 0) {
                    time += diff * 2
                    blocks += diff
                } else if (diff < 0) {
                    time -= diff
                    blocks += diff
                }
            }
        }

        if (blocks >= 0) {
            if (time < bestTime || (time == bestTime && target > bestHeight)) {
                bestTime = time
                bestHeight = target
            }
        }
    }

    println("$bestTime $bestHeight")
}
