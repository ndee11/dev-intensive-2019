package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.models.User
import java.util.*
import ru.skillbranch.devintensive.extensions.format
import Utils.Utils
import ru.skillbranch.devintensive.extensions.humanizeDiff
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.ImageMessage
import ru.skillbranch.devintensive.models.TextMessage
import ru.skillbranch.devintensive.models.Chat


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test fun testFactory(){
        val user1 = User.makeUser("Andrew Rogalenko")
        user1.printMe()

        val user2 = User.makeUser("Lenochka Princess")
        user2.printMe()

        val user3 = User.makeUser("Goshan Rogalenko")
        user3.printMe()

        val user10 = User.makeUser(null)
        user10.printMe()

        val user11 = User.makeUser("")
        user11.printMe()

        val user12 = User.makeUser(" ")
        user12.printMe()

        val user13 = User.makeUser("John")
        user13.printMe()
    }

    @Test fun testDateFormat(){
        println(Date().format())
        println("+ 2 hours " + Date().add(2, TimeUnits.HOUR).format())
        println("+ 7 minutes " + Date().add(7, TimeUnits.MUNUTE).format())
        println("-20 seconds " + Date().add(-20, TimeUnits.SECOND).format())
        println("+100 days " + Date().add(100, TimeUnits.DAY).format())
    }

    @Test fun testInitials(){
        println(Utils.toItitials("Andrew", "Rogalenko"))
        println(Utils.toItitials("Andrew", null))
        println(Utils.toItitials(null, null))
        println(Utils.toItitials("", " "))
    }

    @Test fun testDates2(){
        val date1 = Date()

        var date2 = date1.add(-1, TimeUnits.SECOND)
        println(date2.humanizeDiff(date1))

        date2 = date1.add(-30, TimeUnits.SECOND)
        println(date2.humanizeDiff(date1))

        date2 = date1.add(-48, TimeUnits.SECOND)
        println(date2.humanizeDiff(date1))

        for(i in 2..45){
            date2 = date1.add(-i, TimeUnits.MUNUTE)
            println(date2.humanizeDiff(date1))
        }

        date2 = date1.add(-48, TimeUnits.MUNUTE)
        println(date2.humanizeDiff(date1))

        for(i in 2..22){
            date2 = date1.add(-i, TimeUnits.HOUR)
            println(date2.humanizeDiff(date1))
        }

        date2 = date1.add(-25, TimeUnits.HOUR)
        println(date2.humanizeDiff(date1))

        for(i in 2..360){
            date2 = date1.add(-i, TimeUnits.DAY)
            println(date2.humanizeDiff(date1))
        }

        date2 = date1.add(-365, TimeUnits.DAY)
        println(date2.humanizeDiff(date1))

    }

    @Test fun testTransliteration(){
        var s : String

        s = "Привет! Меня зовут Андрей, я живу где-то в России"
        println(Utils.transliteration(s))
    }

    @Test fun testAbstractFactory(){
        val user = User.makeUser("Rogalenko Andrew")
        val textMessge = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text" )
        val imageMessge = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image" )

        when(textMessge){
            is TextMessage -> println("this is text message")
            is ImageMessage -> println("this is image message")
        }
        println(textMessge.formatMessge())

        when(imageMessge){
            is TextMessage -> println("this is text message")
            is ImageMessage -> println("this is image message")
        }
        println(imageMessge.formatMessge())
    }



}
