import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    graph = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }
    var start: Pair<Int, Int>? = null

    repeat(n) { i ->
        st = StringTokenizer(readLine())

        var j = 0
        while (st.hasMoreTokens()) {
            val value = st.nextToken().toInt()

            if (value == 2) {
                start = Pair(i, j)
                graph[i][j] = 0
                visited[i][j++] = true
                continue
            }

            graph[i][j++] = value
        }
    }

    bfs(start!!)

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!visited[i][j] && graph[i][j] == 1) {
                graph[i][j] = -1
            }
        }
        println(graph[i].joinToString(" "))
    }
}

fun bfs(start: Pair<Int, Int>) {
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(start)

    while(queue.isNotEmpty()) {
        val cur = queue.poll()
        val x = cur.first
        val y = cur.second

        repeat(4) { i ->
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in graph.indices && ny in graph[0].indices && !visited[nx][ny] && graph[nx][ny] != 0) {
                queue.add(Pair(nx, ny))
                graph[nx][ny] = graph[x][y] + 1
                visited[nx][ny] = true
            }
        }
    }
}
