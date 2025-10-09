import java.util.LinkedList
import java.util.Queue

lateinit var graph: Array<MutableList<Int>>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    graph = Array(n + 1) { mutableListOf() }

    repeat(m) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        graph[x].add(y)
        graph[y].add(x)
    }

    var minSum = Int.MAX_VALUE
    var answer = 0

    for (i in 1..n) {
        val sum = bfs(n, i)
        if (sum < minSum) {
            minSum = sum
            answer = i
        }
    }

    println(answer)
}

fun bfs(n: Int, start: Int): Int {
    val visited = IntArray(n + 1) { -1 }
    val queue: Queue<Int> = LinkedList()

    visited[start] = 0
    queue.add(start)

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (next in graph[cur]) {
            if (visited[next] == -1) {
                visited[next] = visited[cur] + 1
                queue.add(next)
            }
        }
    }

    return (1..n).sumOf { visited[it] }
}
