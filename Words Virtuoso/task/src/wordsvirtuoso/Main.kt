package wordsvirtuoso

import java.io.File
import java.util.regex.Pattern

class Words(val firstFile: String, val secondFile: String) {

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

    fun checkFile(file: File) {
        val lines = file.readLines()
        var invalid = 0
        for (word in lines) {
            if (!this.checkWordIfEnglish(word) || !this.checkWordSizeIfFive(word)
                || this.checkIfWordHasDouble(word)
            ) {
                invalid++
            }
        }
        if (invalid > 0) {
            println("Error: $invalid invalid words were found in the ${file.name} file.")
            kotlin.system.exitProcess(1)
        } else {
            // println("All words are valid!")
        }
    }

    fun checkCandidates(file1: File, file2: File) {
        var linesFirst = file1.readLines()
        val linesSecond = file2.readLines()

        linesFirst = linesFirst.map { it.lowercase() }

        var notIncluded = 0
        for (word in linesSecond) {
            if (!linesFirst.contains(word.lowercase())) {
                notIncluded++
            }
        }

        if (notIncluded > 0) {
            println("Error: $notIncluded candidate words are not included in the ${file1.name} file.")
            kotlin.system.exitProcess(1)
        }
    }

    fun start() {
        val firstFile = File(this.firstFile)
        val secondFile = File(this.secondFile)

        checkFile(firstFile)
        checkFile(secondFile)
        checkCandidates(firstFile, secondFile)

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

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Error: Wrong number of arguments.")
        kotlin.system.exitProcess(1)
    }
    if (!File(args[0]).exists()) {
        println("Error: The words file ${args[0]} doesn't exist.")
        kotlin.system.exitProcess(1)
    }
    if (!File(args[1]).exists()) {
        println("Error: The candidate words file ${args[1]} doesn't exist.")
        kotlin.system.exitProcess(1)
    }

    val words = Words(args[0], args[1])
    words.start()
    println("Words Virtuoso")
}
