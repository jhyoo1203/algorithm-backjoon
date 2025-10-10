import java.util.LinkedList
import java.util.Queue

lateinit var graph: Array<IntArray>
lateinit var visited: Array<BooleanArray>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    graph = Array(n) { IntArray(n) }
    visited = Array(n) { BooleanArray(n) }

    repeat(n) { i->
        graph[i] = readLine().map { it - '0' }.toIntArray()
    }

    val result: MutableList<Int> = mutableListOf()
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!visited[i][j] && graph[i][j] == 1) {
                val count = bfs(Pair(i, j))
                result.add(count)
            }
        }
    }

    println(result.size)
    result.sorted().forEach { println(it) }
}

fun bfs(start: Pair<Int, Int>): Int {
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(start.first, start.second))
    visited[start.first][start.second] = true
    var count = 1

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        val x = cur.first
        val y = cur.second

        repeat(dx.size) { i ->
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in graph.indices && ny in graph[0].indices && !visited[nx][ny] && graph[nx][ny] != 0) {
                count++
                queue.add(Pair(nx, ny))
                visited[nx][ny] = true
            }
        }
    }

    return count
}
