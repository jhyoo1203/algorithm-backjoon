import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val notHeardPeople = mutableSetOf<String>()
    val result = mutableListOf<String>()
    val sb = StringBuilder()

    repeat(n) {
        notHeardPeople.add(readLine())
    }

    repeat(m) {
        val person = readLine()
        if (notHeardPeople.contains(person)) {
            result.add(person)
        }
    }

    result.sort()
    sb.append(result.size).append("\n")
    result.forEach { sb.append(it).append("\n") }

    print(sb)
}
