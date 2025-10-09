fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val fruits = readLine().split(" ").map { it.toInt() }.toMutableList()

    var maxLength = 0
    var left = 0
    val map = mutableMapOf<Int, Int>()

    for (right in 0 until n) {
        // 각 과일이 몇 개 있는지 파악해서 담아준다
        map.merge(fruits[right], 1, Int::plus)

        // 과일 종류가 두 종류를 초과하면, 윈도우 축소
        while (map.size > 2) {
            val leftFruit = fruits[left]
            map[leftFruit] = map[leftFruit]!! - 1

            if (map[leftFruit] == 0) {
                map.remove(leftFruit)
            }

            left++
        }

        // 현재 윈도우 크기로 최대값 갱신
        maxLength = maxOf(maxLength, right - left + 1)
    }

    println(maxLength)
}
