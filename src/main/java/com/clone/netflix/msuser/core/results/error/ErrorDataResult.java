package com.clone.netflix.msuser.core.results.error;

import com.clone.netflix.msuser.core.results.DataResult;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(T data, String message) {
        super(data, Boolean.FALSE, message);
    }

    public ErrorDataResult(T data) {
        super(data, Boolean.FALSE);
    }

    public ErrorDataResult(String message) {
        super(null, Boolean.FALSE, message);
    }

    public ErrorDataResult() {
        super(null, Boolean.FALSE);
    }
}
