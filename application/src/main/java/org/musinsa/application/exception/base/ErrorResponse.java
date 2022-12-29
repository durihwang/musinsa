package org.musinsa.application.exception.base;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

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
}
