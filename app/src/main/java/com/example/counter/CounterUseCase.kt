package com.example.counter

import arrow.core.Either

class CounterUseCase {
    var counter: Int = 0
    fun increment() {
        counter++
    }

    fun decrement(): Either<Error, Unit> {
        if (counter > 0) {
            counter--
            Either.Right("")
        }
        return Either.Left(Error("Você não pode ter menos que 1"))

    }

    fun getCounter(): String {
        return counter.toString()
    }
}