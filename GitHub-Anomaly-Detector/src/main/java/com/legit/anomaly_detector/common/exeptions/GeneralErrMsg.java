package com.legit.anomaly_detector.common.exeptions;

import org.springframework.http.HttpStatus;

public interface GeneralErrMsg {
    String getMsg();

    ExceptionArea getArea();

    HttpStatus getHttpStatus();
}
