package wordsvirtuoso

import java.io.File
import java.util.regex.Pattern

class Words() {

    fun askWord(): String {
        println("Input a 5-letter string:")
        return readln()
    }

    fun checkWordSizeIfFive(word: String): Boolean {
        return word.length == 5
    }

    fun checkWordIfEnglish(word: String): Boolean {
        val regex = "[A-Z]+|\\s".toRegex(RegexOption.IGNORE_CASE)
        return regex.matches(word)
    }

    fun checkIfWordHasDouble(word: String): Boolean {
        val regex = "\\b.*([A-Za-z])\\1.*\\b".toRegex(RegexOption.IGNORE_CASE)
        return regex.matches(word)
    }

    fun start() {
        println("Input the words file:")
        val filename = readln()
        val file = File(filename)

        if (file.exists()){
            val lines = file.readLines()
            var invalid = 0
            for (word in lines){
                if (!this.checkWordIfEnglish(word) || !this.checkWordSizeIfFive(word)
                    || this.checkIfWordHasDouble(word)){
                    invalid++
                }
            }
            if (invalid > 0){
                println("Warning: $invalid invalid words were found in the $filename file.")
            } else {
                println("All words are valid!")
            }
        } else {
            println("Error: The words file $filename doesn't exist.")
        }
        kotlin.system.exitProcess(1)

//        val word = this.askWord()
//        if (!this.checkWordIfEnglish(word)) {
//            println("The input has invalid characters.")
//        } else if (!this.checkWordSizeIfFive(word)) {
//            println("The input isn't a 5-letter string.")
//        } else if (this.checkIfWordHasDouble(word)) {
//            println("The input has duplicate letters.")
//        } else {
//            println("The input is a valid string.")
//        }
    }
}

fun main() {
    val words = Words()
    words.start()
}
