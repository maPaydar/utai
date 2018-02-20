package ir.ut.ai.util

import java.text.SimpleDateFormat
import java.text.DateFormat
import java.util.Calendar


object Log {

    enum class Level {
        DEBUG,
        ERROR,
        WARNING,
        INFO
    }

    private val COLOR_RESET = "\u001b[0m"
    private val COLOR_SEVERE = "\u001b[91m"
    private val COLOR_WARNING = "\u001b[93m"
    private val COLOR_INFO = "\u001b[32m"
    private val COLOR_DEBUG = "\u001b[36m"

    var level: Level = Level.INFO

    // [date][tag]: message
    private var format: String = "[%s][%s]: %s"
    private var df: DateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm:ss")


    fun debug(tag: String, message: String) {
        if (level.ordinal <= Level.DEBUG.ordinal)
            print(makeString(tag, message, Level.DEBUG))
    }

    fun info(tag: String, message: String) {
        if (level.ordinal <= Level.INFO.ordinal)
            print(makeString(tag, message, Level.INFO))
    }

    fun warn(tag: String, message: String) {
        print(makeString(tag, message, Level.WARNING))
    }

    fun error(tag: String, message: String) {
        print(makeString(tag, message, Level.ERROR))
    }


    private fun makeString(tag: String, message: String, level: Level): String {
        var prefix = ""
        when (level) {
            Level.INFO -> prefix = COLOR_INFO
            Level.ERROR -> prefix = COLOR_SEVERE
            Level.DEBUG -> prefix = COLOR_DEBUG
            Level.WARNING -> prefix = COLOR_WARNING
        }
        val now = Calendar.getInstance().time
        return prefix + String.format(format, df.format(now), tag, message) + COLOR_RESET + "\n"
    }
}