package com.clone.netflix.msuser.core.results.success;

import com.clone.netflix.msuser.core.results.Result;

public class SuccessResult extends Result {

    public SuccessResult(String message) {
        super(Boolean.TRUE, message);
    }

    public SuccessResult() {
        super(Boolean.TRUE);
    }
}
