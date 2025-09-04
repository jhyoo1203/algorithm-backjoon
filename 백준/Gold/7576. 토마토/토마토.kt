import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    var st = StringTokenizer(readLine())
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val graph = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) }
    val queue = ArrayDeque<Pair<Int, Int>>()

    repeat(n) { i ->
        st = StringTokenizer(readLine())

        repeat(m) { j ->
            val tomato = st.nextToken().toInt()
            graph[i][j] = tomato

            if (tomato == 1) {
                queue.add(Pair(i, j))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val pair = queue.removeFirst()
        val x = pair.first
        val y = pair.second

        visited[x][y] = true

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny]) {
                continue
            }

            if (graph[nx][ny] == 0) {
                queue.add(Pair(nx, ny))
                graph[nx][ny] = graph[x][y] + 1
                visited[nx][ny] = true
            }
        }
    }

    var result = -1
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 0) {
                print(-1)
                return
            }
            result = maxOf(graph[i][j], result)
        }
    }

    print(result - 1)
}
