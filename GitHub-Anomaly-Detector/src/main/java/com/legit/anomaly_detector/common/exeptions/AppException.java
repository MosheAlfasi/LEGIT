package com.legit.anomaly_detector.common.exeptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppException extends Exception {

    private final ExceptionArea exceptionArea;

    private final HttpStatus httpStatus;

    public AppException(GeneralErrMsg generalErrMsg, String... args) {
        super(String.format(generalErrMsg.getMsg(), args));

        exceptionArea = generalErrMsg.getArea();
        httpStatus = generalErrMsg.getHttpStatus();
    }
}
