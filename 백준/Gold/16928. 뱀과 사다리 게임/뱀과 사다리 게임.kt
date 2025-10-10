import java.util.LinkedList
import java.util.Queue

val graph = IntArray(101)
val visited = BooleanArray(101)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    repeat(n + m) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        graph[x] = y
    }

    print(bfs())
}

fun bfs(): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(1 to 0)
    visited[1] = true

    while (queue.isNotEmpty()) {
        val (pos, count) = queue.poll()

        if (pos == 100) return count

        for (i in 1..6) {
            var next = pos + i
            if (next > 100) continue

            if (graph[next] != 0) {
                next = graph[next]
            }

            if (!visited[next]) {
                visited[next] = true
                queue.add(next to count + 1)
            }
        }
    }

    return -1
}
