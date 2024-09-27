package com.example.nullsafe

fun main() {
    val result = fetchFromRemote()
    val nameToDisplay: String = result?.entries?.first()?.name?.firstName ?: "not found"
    // java:
    // if (result != null && result.entries != null && result.entries.firstOrNull() != null &&
    // result.entries.firstOrNull().name != null) {

    println("The first participants first name was: $nameToDisplay")
}

fun fetchFromRemote(): Results? {
    return null
}

data class Results(val entries: List<ParticipantResult>?)

data class ParticipantResult(
    val name: ParticipantName?,
)

data class ParticipantName(
    val firstName: String?,
    val lastName: String?,
)
