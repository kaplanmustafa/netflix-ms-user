package com.clone.netflix.msuser.core.results;

import java.util.UUID;

public class Result {

    private Boolean success;

    private String message;

    private String tid;

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
        this.tid = UUID.randomUUID().toString();
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

    public String getTid() {
        return tid;
    }
}
