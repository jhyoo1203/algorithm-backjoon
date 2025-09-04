import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val arr = Array(n + 1) { Array(n + 1) { false } }
    val queue = ArrayDeque<Int>()
    val visited = Array(n + 1) { false }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        arr[x][y] = true
        arr[y][x] = true
    }

    queue.add(1)
    visited[1] = true
    var count = 0

    while (queue.isNotEmpty()) {
        val target = queue.removeFirst()

        for (i in visited.indices) {
            if (!visited[i] && arr[target][i]) {
                queue.add(i)
                visited[i] = true
                count++
            }
        }
    }

    println(count)
}
