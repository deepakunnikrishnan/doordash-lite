package com.androidnerds.doordash.data.remote;

public class ApiConfig {

    private String baseUrl;

    public ApiConfig(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
