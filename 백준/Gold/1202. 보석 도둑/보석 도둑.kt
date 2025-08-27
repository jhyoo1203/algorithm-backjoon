import java.util.Collections
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val jewels = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    repeat(n) {
        st = StringTokenizer(readLine())
        jewels.add(Pair(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    val bags = IntArray(k)
    repeat(k) { i ->
        bags[i] = readLine().toInt()
    }
    bags.sort()

    val price = PriorityQueue<Int>(Collections.reverseOrder())
    var result = 0L

    for (bag in bags) {
        while (jewels.isNotEmpty()) {
            if (jewels.peek().first <= bag) {
                price.add(jewels.poll().second)
            } else {
                break
            }
        }

        if (price.isNotEmpty()) {
            result += price.poll()
        }
    }

    print(result)
}
