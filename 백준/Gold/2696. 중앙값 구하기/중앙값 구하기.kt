import java.util.Collections
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val m = readLine().toInt()

        val lowPq = PriorityQueue<Int>(Collections.reverseOrder())
        val highPq = PriorityQueue<Int>()

        var count = 0

        sb.append((m + 1) / 2).append("\n")

        // 10개 씩 끊어서 입력
        repeat( m / 10 + 1) {
            val st = StringTokenizer(readLine())

            while (st.hasMoreTokens()) {
                val num = st.nextToken().toInt()

                if (lowPq.isNotEmpty() && num > lowPq.peek()) {
                    highPq.add(num)
                } else {
                    lowPq.add(num)
                }

                // 2개 큐 사이즈 조절
                when {
                    lowPq.size < highPq.size -> {
                        lowPq.add(highPq.poll())
                    }

                    lowPq.size > highPq.size + 1 -> {
                        highPq.add(lowPq.poll())
                    }
                }

                if (count % 2 == 0) {
                    sb.append(lowPq.peek()).append(" ")
                }

                count++
            }

            if (count % 20 == 0) {
                sb.append("\n")
            }
        }

        sb.append("\n")
    }
    print(sb)
}
