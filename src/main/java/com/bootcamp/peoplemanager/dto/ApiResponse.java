package com.bootcamp.peoplemanager.dto;

import lombok.Getter;

@Getter
public class ApiResponse {
    private String message;
    private Object result;
    private boolean error;

    public ApiResponse() {}

    public ApiResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public ApiResponse setError(boolean error) {
        this.error = error;
        return this;
    }

    public ApiResponse setResult(Object result) {
        this.result = result;
        return this;
    }
}
