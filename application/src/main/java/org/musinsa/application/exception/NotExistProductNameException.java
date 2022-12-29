package org.musinsa.application.exception;

import org.musinsa.application.exception.base.ApplicationBaseRunTimeException;
import org.musinsa.application.exception.base.ApplicationErrorCode;
import org.musinsa.application.exception.base.BusinessException;

public class NotExistProductNameException extends BusinessException {

    @Override
    public ApplicationErrorCode getErrorCode() {
        return ApplicationErrorCode.NOT_EXIST_PRODUCT_NAME;
    }
}
