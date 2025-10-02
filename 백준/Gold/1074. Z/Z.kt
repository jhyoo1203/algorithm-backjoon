import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    println(zOrder(n, r, c))
}

fun zOrder(n: Int, r: Int, c: Int): Int {
    if (n == 0) return 0

    val half = 1 shl (n - 1) // 2^(n-1)
    val areaSize = half * half

    return when {
        r < half && c < half -> zOrder(n - 1, r, c) // 왼쪽 위
        r < half && c >= half -> areaSize + zOrder(n - 1, r, c - half) // 오른쪽 위
        r >= half && c < half -> 2 * areaSize + zOrder(n - 1, r - half, c) // 왼쪽 아래
        else -> 3 * areaSize + zOrder(n - 1, r - half, c - half) // 오른쪽 아래
    }
}
