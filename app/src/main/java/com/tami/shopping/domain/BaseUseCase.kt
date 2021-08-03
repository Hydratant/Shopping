package com.tami.shopping.domain

abstract class BaseUseCase {
    inline fun <T> run(function: () -> T): Result<T> {
        return runCatching { function() }
    }
}