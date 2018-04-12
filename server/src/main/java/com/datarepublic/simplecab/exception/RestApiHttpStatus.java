package com.datarepublic.simplecab.exception;

//import com.fasterxml.jackson.annotation.JsonCreator;

public enum RestApiHttpStatus {
    OK(200),
    INTERNAL_SERVER_ERROR(500),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404);

    private final int httpStatus;

    /*@JsonCreator*/ RestApiHttpStatus(int status) {
        this.httpStatus = status;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
