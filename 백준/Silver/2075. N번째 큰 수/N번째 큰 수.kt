import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) {
        readLine().split(" ")
            .map { it.toInt() }
            .forEach(pq::add)
    }

    val stack = Stack<Int>()
    repeat(n) {
        stack.add(pq.poll())
    }

    println(stack.pop())
}
