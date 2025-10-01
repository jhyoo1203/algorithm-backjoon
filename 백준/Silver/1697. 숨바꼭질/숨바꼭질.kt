import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

private const val MAX_GRAPH_SIZE = 100_001

private lateinit var graph: IntArray
private lateinit var visited: BooleanArray
private var k = 0

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    k = st.nextToken().toInt()

    graph = IntArray(MAX_GRAPH_SIZE)
    visited = BooleanArray(MAX_GRAPH_SIZE)

    println(bfs(n))
}

fun bfs(start: Int): Int {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    graph[start] = 0
    visited[start] = true

    while(queue.isNotEmpty()) {
        val cur = queue.poll()
        if (cur == k) {
            return graph[cur]
        }

        val targets = listOf(cur + 1, cur - 1, cur * 2)
        for (target in targets) {
            if (target in 0 until MAX_GRAPH_SIZE && !visited[target]) {
                graph[target] = graph[cur] + 1
                queue.add(target)
                visited[target] = true
            }
        }
    }

    return 0
}