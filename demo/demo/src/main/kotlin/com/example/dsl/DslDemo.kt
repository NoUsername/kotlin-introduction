package com.example.dsl

import org.springframework.validation.MapBindingResult

data class UserSignup(
    val name: String,
    val email: String,
)

fun main() {
    val input = UserSignup("a", "a@some")

    classicalValidation(input)
    dslValidat(input)
}

val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()

fun dslValidat(input: UserSignup) {
    ValidationExceptionUtil.validation {
        if (input.name.length < 2) {
            it.rejectValue(UserSignup::name.name, "name.invalid")
        }

        if (!input.email.matches(emailRegex)) {
            it.rejectValue(UserSignup::name.name, "name.invalid")
        }
    }

    println("validation successful!")
}

fun classicalValidation(input: UserSignup) {
    val errors = MapBindingResult(mapOf<String, Any>(), "validation")

    if (input.name.length < 2) {
        errors.rejectValue(UserSignup::name.name, "name.invalid")
    }

    if (!input.email.matches(emailRegex)) {
        errors.rejectValue(UserSignup::name.name, "name.invalid")
    }

    if (errors.hasErrors()) {
        throw ValidationException(errors)
    }
}
