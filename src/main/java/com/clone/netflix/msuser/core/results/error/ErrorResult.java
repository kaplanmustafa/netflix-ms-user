package com.clone.netflix.msuser.core.results.error;

import com.clone.netflix.msuser.core.results.Result;

public class ErrorResult extends Result {

    public ErrorResult(String message) {
        super(Boolean.FALSE, message);
    }

    public ErrorResult() {
        super(Boolean.FALSE);
    }
}
