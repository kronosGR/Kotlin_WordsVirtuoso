fun main() {
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    // Do not touch lines above
    // Write only exchange actions here.

    val tmp = numbers.last()
    numbers[numbers.size - 1] = numbers.first()
    numbers[0] = tmp
    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}