package org.musinsa.application.exception.base;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ErrorResponse {

    private String errorCode;

    private String errorMessage;

    private List<ErrorBox> errorList;

    public static ErrorResponse create(ApplicationBaseRunTimeException e) {
        ApplicationErrorCode customErrorCode = e.getErrorCode();
        List<ErrorBox> errorBoxList = null;
        ExceptionCauseData causeData = e.getCauseData();
        if (causeData != null) {
            errorBoxList = new ArrayList<>();
            errorBoxList.add(ErrorBox.create(causeData.getCauseValue(), e.getMessage()));
        }

        return new ErrorResponse(customErrorCode.getErrorCode(), customErrorCode.getErrorMessage(),
            errorBoxList);
    }

    public static ErrorResponse create(MethodArgumentNotValidException e) {

        ApplicationErrorCode customErrorCode = ApplicationErrorCode.VALID_EXCEPTION;
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<ErrorBox> errorBoxList = new ArrayList<>();

        fieldErrors.forEach(objectError -> {
            errorBoxList.add(
                ErrorBox.create(objectError.getField(), objectError.getDefaultMessage()));
        });

        return new ErrorResponse(customErrorCode.getErrorCode(), customErrorCode.getErrorMessage(),
            errorBoxList);
    }
}
