package wordsvirtuoso

import java.io.File
import java.lang.Math.random
import java.util.regex.Pattern
import kotlin.random.Random

//class Words(val firstFile: String, val secondFile: String) {
class Words() {

    lateinit var words: List<String>
    lateinit var secretWord: String

    private fun askWord(): String {
        println("Input a 5-letter string:")
        return readln()
    }

    private fun checkWordSizeIfFive(word: String): Boolean {
        return word.length == 5
    }

    private fun checkWordIfEnglish(word: String): Boolean {
        val regex = "[A-Z]+|\\s".toRegex(RegexOption.IGNORE_CASE)
        return regex.matches(word)
    }

    private fun checkIfWordHasDouble(word: String): Boolean {
        val regex = "\\b.*([A-Za-z])\\1.*\\b".toRegex(RegexOption.IGNORE_CASE)
        return regex.matches(word)
    }

    private fun loadWords() {
        words = File("words.txt").readLines()
    }

    private fun getSecretWord() {
        val ran = Random.nextInt(0, words.size)
        secretWord = words[ran]
    }

    private fun wordExists(word: String): Boolean{
        return words.contains(word)
    }

//    private fun checkFile(file: File) {
//        val lines = file.readLines()
//        var invalid = 0
//        for (word in lines) {
//            if (!this.checkWordIfEnglish(word) || !this.checkWordSizeIfFive(word)
//                || this.checkIfWordHasDouble(word)
//            ) {
//                invalid++
//            }
//        }
//        if (invalid > 0) {
//            println("Error: $invalid invalid words were found in the ${file.name} file.")
//            kotlin.system.exitProcess(1)
//        } else {
//            // println("All words are valid!")
//        }
//    }

//    private fun checkCandidates(file1: File, file2: File) {
//        var linesFirst = file1.readLines()
//        val linesSecond = file2.readLines()
//
//        linesFirst = linesFirst.map { it.lowercase() }
//
//        var notIncluded = 0
//        for (word in linesSecond) {
//            if (!linesFirst.contains(word.lowercase())) {
//                notIncluded++
//            }
//        }
//
//        if (notIncluded > 0) {
//            println("Error: $notIncluded candidate words are not included in the ${file1.name} file.")
//            kotlin.system.exitProcess(1)
//        }
//    }

    fun start() {
//        val firstFile = File(this.firstFile)
//        val secondFile = File(this.secondFile)

//        checkFile(firstFile)
//        checkFile(secondFile)
//        checkCandidates(firstFile, secondFile)

        // start title
        println("Words Virtuoso")

        // load words
        loadWords()
        getSecretWord()

        while (true) {
            val word = askWord()

            if (word == "exit") {
                break
            }

            if (!this.checkWordIfEnglish(word)) {
                println("One or more letters of the input aren't valid.")
                continue
            } else if (!this.checkWordSizeIfFive(word)) {
                println("The input isn't a 5-letter word.")
                continue
            } else if (this.checkIfWordHasDouble(word)) {
                println("The input has duplicated letters.")
                continue
            } else if (!this.wordExists(word)){
               // check if in the list
                println("The input word isn't included in my words list.")
            }

        }
    }
}

fun main(args: Array<String>) {
//    if (args.size != 2) {
//        println("Error: Wrong number of arguments.")
//        kotlin.system.exitProcess(1)
//    }
//    if (!File(args[0]).exists()) {
//        println("Error: The words file ${args[0]} doesn't exist.")
//        kotlin.system.exitProcess(1)
//    }
//    if (!File(args[1]).exists()) {
//        println("Error: The candidate words file ${args[1]} doesn't exist.")
//        kotlin.system.exitProcess(1)
//    }

//    val words = Words(args[0], args[1])
    val words = Words();
    words.start()
}
