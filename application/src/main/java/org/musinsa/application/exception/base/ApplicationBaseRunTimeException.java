package org.musinsa.application.exception.base;

public abstract class ApplicationBaseRunTimeException extends RuntimeException {

    private ExceptionCauseData causeData;
    public abstract ApplicationErrorCode getErrorCode();
}
