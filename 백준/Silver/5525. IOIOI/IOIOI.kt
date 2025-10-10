private const val I = 'I'
private const val O = 'O'

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val s = readLine()

    var result = 0
    var count = 0
    var i = 0

    while (i < m - 2) {
        if (s[i] == I && s[i + 1] == O && s[i + 2] == I) {
            count++

            if (count == n) {
                result++
                count--  // 연속된 IOI 중첩 처리z
            }

            i += 2  // "IOI" 패턴은 2칸 전진
        } else {
            count = 0
            i++
        }
    }

    println(result)
}
