import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

private lateinit var graph: Array<MutableList<Int>>
private lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    graph = Array(n + 1) { mutableListOf<Int>() }
    visited = BooleanArray(n + 1)

    repeat(m) {
        st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        graph[x].add(y)
        graph[y].add(x)
    }

    var count = 0
    for (i in 1..n) {
        if (!visited[i]) {
            bfs(i)
            count++
        }
    }

    println(count)
}

fun bfs(start: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (next in graph[cur]) {
            if (!visited[next]) {
                queue.add(next)
                visited[next] = true
            }
        }
    }
}
