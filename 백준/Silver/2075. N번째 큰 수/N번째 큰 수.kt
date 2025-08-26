import java.util.Collections
import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) {
        readLine().split(" ")
            .map { it.toInt() }
            .forEach(pq::add)
    }

    repeat(n - 1) {
        pq.poll()
    }

    println(pq.poll())
}
