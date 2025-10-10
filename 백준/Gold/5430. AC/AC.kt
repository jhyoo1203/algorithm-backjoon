import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val p = readLine()
        val n = readLine().toInt()
        val arr = readLine().removeSurrounding("[", "]").split(",")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
            .toCollection(LinkedList())

        var reversed = false
        var error = false

        for (cmd in p) {
            when (cmd) {
                'R' -> reversed = !reversed
                'D' -> {
                    if (arr.isEmpty()) {
                        error = true
                        break
                    } else {
                        if (reversed) arr.removeLast()
                        else arr.removeFirst()
                    }
                }
            }
        }

        if (error) {
            println("error")
        } else {
            val result = if (reversed) arr.reversed() else arr
            println(result.joinToString(prefix = "[", postfix = "]", separator = ","))
        }
    }
}
