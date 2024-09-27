package com.example.interop

class Interop {

    fun normalMethod(): String {
        return "hello from kotlin ${System.nanoTime()}"
    }

    val stringProperty = "hello from lazy ${System.nanoTime()}"

    var mutableStringProperty = "hello from initial value of mutableStringProperty"

    val lazyString: String by lazy { "hello from lazy ${System.nanoTime()}" }

    companion object {
        fun methodFromCompanion() = "hello from companion ${System.nanoTime()}"
    }
}

object InteropObject {

    fun methodFromObject(): String {
        return "hello from methodFromObject ${System.nanoTime()}"
    }
}

fun classlessMethod(): String {
    return "hello from classlessMethod ${System.nanoTime()}"
}

val classlessVal = "hello from classlessVal ${System.nanoTime()}"
