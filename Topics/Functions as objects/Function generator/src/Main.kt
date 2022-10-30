// TODO: provide three functions here
fun identity(num: Int) = num

fun half(num: Int) = num / 2

fun zero(num: Int) = 0

fun generate(functionName: String): (Int) -> Int {
    // TODO: provide implementation here
    when (functionName) {
        "half" -> return ::half
        "zero" -> return ::zero
        "identity" -> return ::identity
        else -> return ::zero
    }
}