package com.tami.shopping.domain

/**
 * UseCase runCatching 공통화
 */
abstract class BaseUseCase {
    inline fun <T> run(function: () -> T): Result<T> {
        return runCatching { function() }
    }
}