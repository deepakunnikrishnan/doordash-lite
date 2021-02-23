package com.androidnerds.doordash.core.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListMapperImpl<I,O> implements ListMapper<I,O> {

    private Mapper<I,O> mapper;

    public ListMapperImpl(Mapper<I,O> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<O> map(List<I> input) {
        return null == input ? Collections.emptyList(): input.stream().map(i -> mapper.map(i)).collect(Collectors.toList());
    }
}

