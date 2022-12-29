package org.musinsa.application.exception.base;

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

    /*public static ErrorResponse create(ApplicationBaseRunTimeException e) {
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

    public static ErrorResponse create(PageableSortParameterException e) {
        ApplicationErrorCode customErrorCode = ApplicationErrorCode.PAGEABLE_SORT_PARAMETER;
        List<ErrorBox> errorBoxList = null;

        ExceptionCauseData causeData = new ExceptionCauseData(e.getCauseData());
        errorBoxList = new ArrayList<>();
        errorBoxList.add(ErrorBox.create(causeData.getCauseValue(), e.getMessage()));

        return new ErrorResponse(customErrorCode.getErrorCode(), customErrorCode.getErrorMessage(),
            errorBoxList);
    }

    public static ErrorResponse create(MissingServletRequestParameterException e) {
        ApplicationErrorCode customErrorCode = ApplicationErrorCode.NOT_EXIST_QUERY_STRING;
        String parameterType = e.getParameterType();
        String parameterName = e.getParameterName();
        ErrorBox errorBox = ErrorBox
            .create(parameterName + "(" + parameterType + ")", "파라미터가 필요합니다.");
        List<ErrorBox> errorBoxList = new ArrayList<>();
        errorBoxList.add(errorBox);
        return new ErrorResponse(customErrorCode.getErrorCode(), customErrorCode.getErrorMessage(),
            errorBoxList);
    }

    public static ErrorResponse create(MethodArgumentNotValidException e) {
        ApplicationErrorCode customErrorCode = ApplicationErrorCode.REQUEST_BODY_VALIDATE_ERROR;
        BindingResult bindingResult = e.getBindingResult();

        List<ErrorBox> errorBoxList = bindingResult.getFieldErrors().stream().map(
            fieldError -> ErrorBox.create(fieldError.getField(), fieldError.getDefaultMessage()))
            .collect(Collectors.toList());

        return new ErrorResponse(customErrorCode.getErrorCode(), customErrorCode.getErrorMessage(),
            errorBoxList);
    }*/

  /*public static ErrorResponse create(RequestDataConstraintViolationException e) {
    ApplicationErrorCode customErrorCode = e.getErrorCode();
    Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
    List<ErrorBox> errorBoxList = new ArrayList<>();

    for (ConstraintViolation<?> constraintViolation : constraintViolations) {
      errorBoxList.add(ErrorBox.create(constraintViolation));
    }

    return new ErrorResponse(customErrorCode.getErrorCode(), customErrorCode.getErrorMessage(),
        errorBoxList);
  }

  public static ErrorResponse create(RequestDataBindingResultValidationException e) {
    ApplicationErrorCode customErrorCode = e.getErrorCode();
    BindingResult bindingResult = e.getBindingResult();
    List<ErrorBox> errorBoxList = new ArrayList<>();

    for (FieldError fieldError : bindingResult.getFieldErrors()) {
      errorBoxList.add(ErrorBox.create(fieldError));
    }

    return new ErrorResponse(customErrorCode.getErrorCode(), customErrorCode.getErrorMessage(),
        errorBoxList);
  }*/
}
