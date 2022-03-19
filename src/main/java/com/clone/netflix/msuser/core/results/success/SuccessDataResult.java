package com.clone.netflix.msuser.core.results.success;

import com.clone.netflix.msuser.core.results.DataResult;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data, String message) {
        super(data, Boolean.TRUE, message);
    }

    public SuccessDataResult(T data) {
        super(data, Boolean.TRUE);
    }

    public SuccessDataResult(String message) {
        super(null, Boolean.TRUE, message);
    }

    public SuccessDataResult() {
        super(null, Boolean.TRUE);
    }
}
