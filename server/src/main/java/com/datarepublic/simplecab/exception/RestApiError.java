package com.datarepublic.simplecab.exception;

import com.fasterxml.jackson.annotation.JsonCreator;

public class RestApiError {
    private final int httpStatus;
    private String userMessage;
    private String headline;

    @JsonCreator public RestApiError(RestApiHttpStatus status) {
        this.httpStatus = status.getHttpStatus();
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getHeadline() {
        return headline;
    }

    public RestApiError setUserMessage(String userMessage) {
        this.userMessage = userMessage;
        return this;
    }

    public RestApiError setHeadline(String headline) {
        this.headline = headline;
        return this;
    }
}
