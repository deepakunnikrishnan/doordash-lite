package com.androidnerds.doordash.core.utils;

public class Result<Data, Error> {
    
    private Data t;

    private Error e;
    
    public Result(Data t, Error e) {
        this.t = t;
        this.e = e;
    }

    public Data getData() {
        return t;
    }

    public Error getError() {
        return e;
    }
}
