import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val people = mutableListOf<Int>()

    while (st.hasMoreTokens()) {
        people.add(st.nextToken().toInt())
    }

    people.sort()

    var sum = 0
    var result = 0

    people.forEach { person ->
        sum += person
        result += sum
    }

    print(result)
}
