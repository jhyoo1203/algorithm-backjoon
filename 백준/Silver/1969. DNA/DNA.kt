fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val dnas = Array(n) { readLine() }

    val result = StringBuilder()
    var hammingDistance = 0

    for (i in 0 until m) {
        val cnt = mutableMapOf<Char, Int>()
        for (dna in dnas) {
            cnt[dna[i]] = cnt.getOrDefault(dna[i], 0) + 1
        }

        val freqChar = cnt.entries.sortedWith(compareBy({ -it.value }, { it.key }))[0].key
        result.append(freqChar)

        hammingDistance += n - (cnt[freqChar] ?: 0)
    }

    println(result.toString())
    println(hammingDistance)
}
