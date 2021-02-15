package com.androidnerds.doordash.core

sealed class Result<T, E> {

    data class Success<T>(val value: T) : Result<T, Nothing>()

    data class Failure<E>(val error: E) : Result<Nothing, E>()

    inline fun <C> fold(success: (T) -> C, failure: (E) -> C): C = when (this) {
        is Success -> success(value)
        is Failure -> failure(error)
    }

}

typealias SimpleResult<T> = Result<T, Throwable>