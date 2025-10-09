import java.util.LinkedList
import java.util.Queue

lateinit var graph: Array<IntArray>
lateinit var visited: Array<BooleanArray>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    graph = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    repeat(n) { i->
        graph[i] = readLine().map { it - '0' }.toIntArray()
    }

    bfs(Pair(0, 0))
    println(graph[n - 1][m - 1])
}

fun bfs(start: Pair<Int, Int>) {
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.add(Pair(start.first, start.second))
    visited[start.first][start.second] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        val x = cur.first
        val y = cur.second

        repeat(dx.size) { i ->
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
