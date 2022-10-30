fun main() {
    // write your code here
    var size = readln().toInt()
    val array = IntArray(size)
    for (i in 0 until size) {
        array[i] = readln().toInt()
    }

    var triplesAmount = 0
    for (i in 0..array.lastIndex - 2) {
        if (array[i] == array[i + 1] - 1 && array[i] == array[i + 2] - 2) {
            triplesAmount++
        }
    }
    println(triplesAmount)
}