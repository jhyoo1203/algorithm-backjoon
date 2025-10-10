lateinit var graph: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    graph = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(n) }

    // 일반인
    var basic = 0
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!visited[i][j]) {
                dfs(i, j, graph[i][j])
                basic++
            }
        }
    }

    // 적록색약
    visited.forEach { it.fill(false) }
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            // G -> R로 치환
            if (graph[i][j] == 'G') graph[i][j] = 'R'
        }
    }
    var redGreen = 0
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!visited[i][j]) {
                dfs(i, j, graph[i][j])
                redGreen++
            }
        }
    }

    print("$basic $redGreen")
}

fun dfs(x: Int, y: Int, color: Char) {
    visited[x][y] = true

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx in graph.indices && ny in graph[0].indices && !visited[nx][ny] && graph[nx][ny] == color) {
            dfs(nx, ny, color)
        }
    }
}
