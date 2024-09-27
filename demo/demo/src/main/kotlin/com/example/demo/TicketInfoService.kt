package com.example.demo

import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit
import org.springframework.stereotype.Service

interface TicketInfoService {

    fun ticketsDone(): Int
}

@Service
class TicketInfoServiceImpl : TicketInfoService {

    val start: OffsetDateTime = OffsetDateTime.now()

    override fun ticketsDone(): Int {
        val secondsElapsed = start.until(OffsetDateTime.now(), ChronoUnit.SECONDS)
        return (secondsElapsed * 0.3).toInt()
    }
}
