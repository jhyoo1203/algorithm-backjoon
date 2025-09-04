import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    data class Pos(val x: Int, val y: Int, val z: Int)

    val dx = intArrayOf(-1, 1, 0, 0, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1, 0, 0)
    val dz = intArrayOf(0, 0, 0, 0, -1, 1)

    var st = StringTokenizer(readLine())
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val h = st.nextToken().toInt()

    val graph = Array(h) { Array(n) { IntArray(m) } }
    val visited = Array(h) { Array(n) { BooleanArray(m) } }
    val queue = ArrayDeque<Pos>()

    repeat(h) { z ->
        repeat(n) { x ->
            st = StringTokenizer(readLine())
            repeat(m) { y ->
                val tomato = st.nextToken().toInt()
                graph[z][x][y] = tomato
                if (tomato == 1) {
                    queue.add(Pos(x, y, z))
                    visited[z][x][y] = true
                }
            }
        }
    }

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()
        val x = cur.x
        val y = cur.y
        val z = cur.z

        for (i in 0 until 6) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            val nz = z + dz[i]

            if (nx !in 0 until n || ny !in 0 until m || nz !in 0 until h) continue
            if (visited[nz][nx][ny]) continue

            if (graph[nz][nx][ny] == 0) {
                graph[nz][nx][ny] = graph[z][x][y] + 1
                visited[nz][nx][ny] = true
                queue.add(Pos(nx, ny, nz))
            }
        }
    }

    var result = 0
    for (z in 0 until h) {
        for (x in 0 until n) {
            for (y in 0 until m) {
                if (graph[z][x][y] == 0) {
                    println(-1)
                    return
                }
                result = maxOf(result, graph[z][x][y])
            }
        }
    }

    println(result - 1)
}
