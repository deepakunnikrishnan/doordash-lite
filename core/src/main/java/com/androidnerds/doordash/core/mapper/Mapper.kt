package com.androidnerds.doordash.core.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}