package practice.email.executable

import practice.email.parser.Email
import practice.email.parser.EmailParser
import practice.email.parser.QuotesHeaderSuggestions
import practice.email.parser.preprocess
import quoteParser.Content
import quoteParser.QuoteParser
import quoteParser.getEmailText
import quoteParser.parse
import java.io.*
import java.util.*
import java.util.regex.Pattern
import java.util.stream.Collectors

private val pathDatasets = ".${File.separator}src${File.separator}main${File.separator}" +
        "resources${File.separator}datasets${File.separator}"
private val pathEmails = "C:${File.separator}YT${File.separator}"


private val FILTER_STRING = "##- Please type your reply above this line -##"

private val EMAILS_COUNT = 23055

fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    val expected_headers = readHeaders(File("${pathDatasets}expected_headers.txt"), verbose = true)
    val actual_headers = getActualHeaders(verbose = true)
    println("Expected headers: ${expected_headers.size}")
    println("Actual headers: ${actual_headers.size}")
    compareHeaders(expected_headers, actual_headers)
    val end = System.currentTimeMillis()
    println("Working time: ${(end - start) / 1000.0} sec.")
}

private fun readHeaders(file: File, verbose: Boolean = false): List<Pair<Int, List<String>>> {
    if (verbose) {
        print("Reading expected headers...")
    }

    val inf = BufferedReader(InputStreamReader(FileInputStream(file)))
    var num: Int
    val lines = inf.lines().collect(Collectors.toList())
    var i = 0
    val headers: MutableList<Pair<Int, List<String>>> = mutableListOf()
    while (i < lines.size) {
        val line = (lines[i] as String)
        num = line.toInt()
        i++
        val header: MutableList<String> = mutableListOf()
        while (i < lines.size && (lines[i] as String) != "") {
            header.add(lines[i] as String)
            i++
        }
        headers.add(Pair(num, header))
        ++i
    }

    if (verbose) {
        println("Done")
    }

    return headers
}

private fun getActualHeaders(verbose: Boolean = false): List<Pair<Int, List<String>>> {
    if (verbose) {
        println("Evaluateing actual headers...")
    }

    val headers: MutableList<Pair<Int, List<String>>> = mutableListOf()

    for (i in 0..EMAILS_COUNT - 1) {
        val header: List<String>?
        val emailText: List<String>
        try {
            emailText = getEmailText(File("${pathEmails}${i}.eml")).lines()

            if (!emailText[0].trim().equals(FILTER_STRING)) {
                header = QuoteParser(emailText).parse().header?.text
            } else {
                header = null
            }
        } catch(e: Exception) {
            println("${i}.eml gave an error while parsing: ${e.message}")
            println("Skipping...")
            continue
        } catch(e: Error) {
            println("Some error with eml ${i}.")
            println("Message: ${e.message}")
            println("Skipping...")
            continue
        }

        if (header != null) {
            try {
                headers.add(Pair(i, header))
            } catch (e: StringIndexOutOfBoundsException) {
                println("Indexing error with eml ${i}.")
                throw e
            }
        }

        if (verbose && i % 100 == 0) {
            println("$i is passed")
        }
    }

    if (verbose) {
        println("Done")
    }

    return headers
}

private fun compareHeaders(expected_headers: List<Pair<Int, List<String>>>,
                           actual_headers: List<Pair<Int, List<String>>>) {
    val not_eqFile = BufferedWriter(OutputStreamWriter(FileOutputStream(File(
            "${pathDatasets}not_equals.txt"
    ))))
    val missedFile = BufferedWriter(OutputStreamWriter(FileOutputStream(File(
            "${pathDatasets}missed.txt"
    ))))
    val newFile = BufferedWriter(OutputStreamWriter(FileOutputStream(File(
            "${pathDatasets}new.txt"
    ))))

    var passed = true
    var equals = 0
    var non_equals = 0
    var new = 0
    var missed = 0

    var expected_index = 0
    var actual_index = 0
    while (expected_index < expected_headers.size) {
        val expected_email_num = expected_headers[expected_index].first
        val expected_header = expected_headers[expected_index].second
        val actual_email_num = actual_headers[actual_index].first
        val actual_header = actual_headers[actual_index].second

        if (expected_email_num == actual_email_num) {
            if (expected_header.equals(actual_header)) {
                expected_index++
                actual_index++
                equals++
                continue
            }
            not_eqFile.write(actual_email_num.toString())
            not_eqFile.newLine()
            not_eqFile.newLine()
            not_eqFile.write("Expected:\n")
            expected_header.forEach {
                not_eqFile.write(it)
                not_eqFile.newLine()
            }
            not_eqFile.newLine()
            not_eqFile.write("Actual:\n")
            actual_header.forEach {
                not_eqFile.write(it)
                not_eqFile.newLine()
            }
            not_eqFile.newLine()
            not_eqFile.write("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n")

            expected_index++
            actual_index++
            non_equals++
        } else {
            if (expected_email_num > actual_email_num) {
                newFile.write(actual_email_num)
                newFile.newLine()
                actual_header.forEach {
                    newFile.write(it)
                    newFile.newLine()
                }
                newFile.newLine()
                actual_index++
                new++
            } else if (expected_email_num < actual_email_num) {
                missedFile.write(expected_email_num)
                missedFile.newLine()
                expected_header.forEach {
                    missedFile.write(it)
                    missedFile.newLine()
                }
                missedFile.newLine()
                expected_index++
                missed++
            }
        }
        passed = false
    }

    if (passed) {
        println("All passed!")
    }

    println("Equals: $equals")
    println("Non equals: $non_equals")
    println("New: $new")
    println("Missed: $missed")

    missedFile.close()
    newFile.close()
    not_eqFile.close()
}