package com.example.fn

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val logMe = { msg: String ->
    println("${LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)} $msg")
}

fun main() {
    logMe("start")

    val paul = ParticipantResult("Paul", 5)
    val frank = ParticipantResult("Frank", 10)

    val winner =
        if (paul.points > frank.points) {
            paul
        } else {
            frank
        }
    logMe("The winner is: ${winner.name}")

    val points = calculateRemoteParticipantsPoints()
    logMe("Remote participants total points: ${points}")

    logMe("end")
}

fun calculateRemoteParticipantsPoints(): Int {
    val fetchedParticipants =
        try {
            fetch()
        } catch (e: Exception) {
            logMe("error fetching remote participants (${e.message})")
            emptyList()
        }

    return fetchedParticipants.sumOf {
        when (it.type) {
            ParticipantType.TRAINING -> 0
            ParticipantType.NORMAL -> it.points
        }
    }
}

fun fetch(): List<ParticipantResult> {
    throw RuntimeException("Some fake Error")
    // return listOf(
    //    ParticipantResult("real", 1),
    //    ParticipantResult("real2", 2),
    //    ParticipantResult("training", 1000, ParticipantType.TRAINING),
    // )
}

data class ParticipantResult(
    val name: String,
    val points: Int,
    val type: ParticipantType = ParticipantType.NORMAL
)

enum class ParticipantType {
    NORMAL,
    TRAINING,
}
