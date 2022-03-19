package com.clone.netflix.msuser.core.results;

public class Result {

    private Boolean success;

    private String message;

    public Result(Boolean success, String message) {
        this(success);
        this.message = message;
    }

    public Result(Boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
