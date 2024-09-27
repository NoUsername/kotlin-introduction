package com.example.dsl

import org.springframework.validation.Errors
import org.springframework.validation.MapBindingResult

class ValidationException(val errors: Errors) : RuntimeException() {}

object ValidationExceptionUtil {
    fun validation(validation: (Errors) -> Unit) {
        val errors = MapBindingResult(mapOf<String, Any>(), "validation")
        validation(errors)
        if (errors.hasErrors()) {
            throw ValidationException(errors)
        }
    }
}
