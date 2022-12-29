package org.musinsa.application.exception.base;

import lombok.Getter;

@Getter
public class ExceptionCauseData {

    private String causeValue;

    public ExceptionCauseData(String causeValue) {
        this.causeValue = causeValue;
    }
}
