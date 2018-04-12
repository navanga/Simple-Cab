package com.datarepublic.simplecab.exception;

public class RestApiException extends RuntimeException {

    private RestApiError error;

    public RestApiException(RestApiError error) {
        this.error = error;
    }

    public RestApiException(RestApiHttpStatus status) {
        this.error = new RestApiError(status);
    }

    public RestApiException userMessage(String message) {
        this.error.setUserMessage(message);
        return this;
    }

    public RestApiException headline(String headline) {
        this.error.setHeadline(headline);
        return this;
    }

    public RestApiError getError() {
        return error;
    }
}
