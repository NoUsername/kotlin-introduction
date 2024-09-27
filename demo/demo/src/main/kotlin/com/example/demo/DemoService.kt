package com.example.demo

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class DemoService(val ticketInfoService: TicketInfoService) {

    @Scheduled(fixedRate = 1000)
    fun showTicketsDone() {
        println("tickets done until now: ${ticketInfoService.ticketsDone()}")
    }
}
