package com.ss.quickStart.core;

public class BizException extends RuntimeException {
    private int errorCode;

    public BizException(int errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BizException(String message) {
        super(message);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
