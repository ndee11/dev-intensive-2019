package ru.skillbranch.devintensive.extensions

import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = java.text.SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MUNUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    var date = Date()
    date.time = time
    return date
}

fun Date.humanizeDiff(date: Date = Date()): String {
//    date.
    val secondsBetween = date.time - this.time
    var ret: String = ""
    if (secondsBetween <= 1 * SECOND) {
        ret = "только что"
    } else if (secondsBetween <= 45 * SECOND) {
        ret = "несколько секунд назад"
    } else if (secondsBetween <= 75 * SECOND) {
        ret = "минуту назад"
    } else if (secondsBetween <= 45 * MINUTE) {
        val colMin: Long = secondsBetween / MINUTE;
        val sColMin: String = colMin.toString();
        val lastChar: String = sColMin.substring(sColMin.length - 1)
        val iLastChar: Int = lastChar.toInt();
        var minuteSuf: String = ""
        if (iLastChar == 1 && colMin > 20) {
            minuteSuf = "у"
        } else if (iLastChar in 2..4 && (colMin > 20 || colMin < 10)) {
            minuteSuf = "ы"
        }
        ret = "$colMin минут$minuteSuf назад"
    } else if (secondsBetween <= 75 * MINUTE) {
        ret = "час назад"
    } else if (secondsBetween <= 22 * HOUR) {
        val colHour: Long = secondsBetween / HOUR;
        var hourSuf: String = ""
        if (colHour == 1L || colHour == 21L) {
            hourSuf = ""
        } else if (colHour in 2..4 || colHour in 22..24) {
            hourSuf = "а"
        } else {
            hourSuf = "ов"
        }
        ret = "$colHour час$hourSuf назад"
    } else if (secondsBetween <= 26 * HOUR) {
        ret = "день назад"
    } else if (secondsBetween <= 360 * DAY) {
        val colDay: Long = secondsBetween / DAY;
        val sColDay: String = colDay.toString();
        val lastChar: String = sColDay.substring(sColDay.length - 1)
        val iLastChar: Int = lastChar.toInt();
        var day: String = ""
        if (iLastChar == 1 && colDay > 20) {
            day = "день"
        } else if (iLastChar in 2..4 && (colDay > 20 || colDay < 10)) {
            day = "дня"
        } else {
            day = "дней"
        }
        ret = "$colDay $day назад"
    } else {
        ret = "более года назад"
    }
    return ret
}

enum class TimeUnits { SECOND, MUNUTE, HOUR, DAY }