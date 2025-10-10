import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val k = readLine().toInt()

        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        val countMap = mutableMapOf<Int, Int>()  // 각 값의 유효 개수 추적

        repeat(k) {
            val (cmd, numStr) = readLine().split(" ")
            val num = numStr.toInt()

            when (cmd) {
                "I" -> {
                    minHeap.add(num)
                    maxHeap.add(num)
                    countMap.merge(num, 1, Int::plus)
                }
                "D" -> {
                    if (countMap.isEmpty()) return@repeat
                    if (num == 1) { // 최댓값 삭제
                        removeInvalid(maxHeap, countMap)
                        if (maxHeap.isNotEmpty()) {
                            val max = maxHeap.poll()
                            countMap.merge(max, 1, Int::minus)
                            if (countMap[max] == 0) countMap.remove(max)
                        }
                    } else { // 최솟값 삭제
                        removeInvalid(minHeap, countMap)
                        if (minHeap.isNotEmpty()) {
                            val min = minHeap.poll()
                            countMap.merge(min, 1, Int::minus)
                            if (countMap[min] == 0) countMap.remove(min)
                        }
                    }
                }
            }
        }

        // 남은 유효하지 않은 값 제거
        removeInvalid(minHeap, countMap)
        removeInvalid(maxHeap, countMap)

        if (countMap.isEmpty()) {
            println("EMPTY")
        } else {
            println("${maxHeap.peek()} ${minHeap.peek()}")
        }
    }
}

fun removeInvalid(pq: PriorityQueue<Int>, countMap: MutableMap<Int, Int>) {
    while (pq.isNotEmpty() && countMap[pq.peek()] == null) {
        pq.poll()
    }
}
