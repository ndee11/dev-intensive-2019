package ru.skillbranch.devintensive.models

import Utils.Utils
import java.util.*

class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id
        , firstName = firstName
        , lastName = lastName
        , avatar = null
    )

    fun printMe(): Unit {
        println(
            """
            ============================================
            id = $id
            firstName = $firstName
            lastName = $lastName
            avatar = $avatar
            rating = $rating
            respect = $respect
            lastVisit = $lastVisit
            isOnline = $isOnline
        """.trimIndent()

        )
    }


    companion object Factory {
        private var lastId: Int = -1

        fun makeUser(fullName: String?): User {
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(
                id = "$lastId"
                , firstName = firstName
                , lastName = lastName
                )

        }
    }
}