package com.androidnerds.doordash.core.mapper;

public interface Mapper<I,O> {
    O map(I input);
}
