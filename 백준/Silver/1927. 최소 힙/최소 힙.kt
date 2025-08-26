import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>()

    repeat(n) {
        val x = readLine().toInt()
        if (x > 0) {
            pq.add(x)
        } else if (pq.isEmpty()) {
            println(0)
        } else {
            println(pq.poll())
        }
    }
}
