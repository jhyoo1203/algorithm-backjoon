import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

lateinit var graph: Array<CharArray>
lateinit var visited: Array<BooleanArray>

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    graph = Array(n) { CharArray(m) }
    visited = Array(n) { BooleanArray(m) }
    lateinit var start: Pair<Int, Int>

    repeat(n) { i ->
        val row = readLine().toCharArray()
        graph[i] = row
        row.forEachIndexed { j, c ->
            if (c == 'I') {
                start = Pair(i, j)
                visited[i][j] = true
            }
        }
    }

    println(bfs(start))
}

fun bfs(start: Pair<Int, Int>): String {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    var count = 0
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(start)

    while (queue.isNotEmpty()) {
        val pair = queue.poll()
        val x = pair.first
        val y = pair.second

        repeat(dx.size) { i ->
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in graph.indices && ny in graph[0].indices && !visited[nx][ny] && graph[nx][ny] != 'X') {
                queue.add(Pair(nx, ny))
                visited[nx][ny] = true

                if (graph[nx][ny] == 'P') {
                    count++
                }
            }
        }

    }
    return if (count > 0) count.toString() else "TT"
}
