import java.util.*

fun main() {
    // write your code here

    val size = readln().toInt()
    val array = IntArray(size)

    for (i in 0..array.lastIndex) {
        array[i] = readln().toInt()
    }

    var list = array.toList()

    Collections.rotate(list, 1)
    println(list.toIntArray().joinToString(" "))
}