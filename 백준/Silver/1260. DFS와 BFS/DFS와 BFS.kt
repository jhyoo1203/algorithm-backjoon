import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

private lateinit var graph: Array<IntArray>
private lateinit var visit: BooleanArray
private var sb = StringBuilder()
private var n = 0
private var m = 0
private var v = 0

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    v = st.nextToken().toInt()

    graph = Array(n + 1) { IntArray(n + 1) }
    visit = BooleanArray(n + 1)

    repeat(m) {
        st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        graph[x][y] = 1
        graph[y][x] = 1
    }

    dfs(v)
    sb.appendLine()

    visit.fill(false)
    bfs(v)

    println(sb.toString())
}

private fun dfs(v: Int) {
    visit[v] = true
    sb.append("$v ")

    for (i in 1..n) {
        if (!visit[i] && graph[v][i] == 1) {
            dfs(i)
        }
    }
}

private fun bfs(v: Int) {
    val q: Queue<Int> = LinkedList()
    q.add(v)
    visit[v] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()
        sb.append("$cur ")

        for (i in 1..n) {
            if (!visit[i] && graph[cur][i] == 1) {
                visit[i] = true
                q.add(i)
            }
        }
    }
}
