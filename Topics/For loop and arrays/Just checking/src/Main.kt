fun main() {
    // write your code here
    val size = readln().toInt()
    val array = IntArray(size)
    for (i in array.indices) {
        array[i] = readln().toInt()
    }

    val (p, n) = readln().split(" ").map { it.toInt() }

    if (array.contains(p) && array.contains(n)) {
        println("YES")
    } else {
        println("NO")
    }
}