fun main() {
    var backFromTheWall = readLine()!!.split(',').map { it }.toTypedArray()
    val returnedWatchman = readLine()!!.toString()  
    // do not touch the lines above
    // write your code here
    val final = backFromTheWall + returnedWatchman
    println(final.joinToString(", "))

}