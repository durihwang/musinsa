package org.musinsa.application.exception.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ApplicationErrorCode {

    NOT_EXIST_PRODUCT_NAME("E-0001", "존재하지 않는 상품입니다.", HttpStatus.BAD_REQUEST),
    NOT_EXIST_PRODUCT_OPTION("E-0002", "존재하지 않는 옵션입니다.", HttpStatus.BAD_REQUEST),
    QUANTITY_EXCEPTION("E-0003", "수량은 마이너스가 될 수 없습니다.", HttpStatus.BAD_REQUEST),
    VALID_EXCEPTION("V-0001", "파라미터 오류", HttpStatus.BAD_REQUEST);

    private final String errorCode;

    private final String errorMessage;

    private final HttpStatus httpStatus;
}
