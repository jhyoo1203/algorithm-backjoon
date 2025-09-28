import java.util.StringTokenizer

private lateinit var paper: Array<IntArray>
private var white = 0
private var blue = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    paper = Array(n) { IntArray(n) }

    repeat(n) { i ->
        val st = StringTokenizer(readLine())
        repeat(n) { j ->
            paper[i][j] = st.nextToken().toInt()
        }
    }

    cut(0, 0, n)
    println(white)
    println(blue)
}

private fun cut(x: Int, y: Int, size: Int) {
    if (checkSameColor(x, y, size)) {
        if (paper[x][y] == 0) white++ else blue++
        return
    }

    val newSize = size / 2
    cut(x, y, newSize) // 왼쪽 위
    cut(x, y + newSize, newSize) // 오른쪽 위
    cut(x + newSize, y, newSize) // 왼쪽 아래
    cut(x + newSize, y + newSize, newSize) // 오른쪽 아래
}

private fun checkSameColor(x: Int, y: Int, size: Int): Boolean {
    val color = paper[x][y]
    for (i in x until x + size) {
        for (j in y until y + size) {
            if (paper[i][j] != color) return false
        }
    }
    return true
}