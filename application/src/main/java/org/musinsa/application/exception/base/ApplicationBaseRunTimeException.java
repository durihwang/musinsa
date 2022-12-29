package org.musinsa.application.exception.base;

import lombok.Getter;

@Getter
public abstract class ApplicationBaseRunTimeException extends RuntimeException {

    private ExceptionCauseData causeData;

    public ApplicationBaseRunTimeException() {
        super();
    }

    public ApplicationBaseRunTimeException(String message) {
        super(message);
    }

    public ApplicationBaseRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationBaseRunTimeException(Throwable cause) {
        super(cause);
    }

    protected ApplicationBaseRunTimeException(String message, Throwable cause,
        boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public abstract ApplicationErrorCode getErrorCode();
}
