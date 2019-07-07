package ru.skillbranch.devintensive.models

import java.util.*
import ru.skillbranch.devintensive.extensions.humanizeDiff

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessge(): String =
        "id:$id ${from?.firstName} ${if (isIncoming) "получил" else "отправил"} сообщение \"$text\" ${date.humanizeDiff()}"
}