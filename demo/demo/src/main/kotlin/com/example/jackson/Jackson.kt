package com.example.jackson

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

fun main() {
    val mapper = jacksonObjectMapper()

    // where did the Jackson generics go?
    val p: Person =
        mapper.readValue(
            """
            {
            "firstName": "Paul",
            "lastName": "Klingelhuber"
            }
        """
                .trimIndent())

    println("Person first=${p.firstName} last=${p.lastName}")
}

data class Person(
    val firstName: String,
    val lastName: String,
)
