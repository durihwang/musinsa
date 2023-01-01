package org.musinsa.application.exception;

import org.musinsa.application.exception.base.ApplicationBaseRunTimeException;
import org.musinsa.application.exception.base.ApplicationErrorCode;
import org.musinsa.application.exception.base.ExceptionCauseData;

public class QuantityException extends ApplicationBaseRunTimeException {

    @Override
    public ExceptionCauseData getCauseData() {
        return super.getCauseData();
    }

    public QuantityException() {
        super();
    }

    public QuantityException(String message) {
        super(message);
    }

    public QuantityException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuantityException(Throwable cause) {
        super(cause);
    }

    protected QuantityException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public ApplicationErrorCode getErrorCode() {
        return ApplicationErrorCode.QUANTITY_EXCEPTION;
    }
}
