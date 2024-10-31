package com.legit.GitHub_Anomaly_Detector.common.exeptions;

import org.springframework.http.HttpStatus;

public interface GeneralErrMsg {
    String getMsg();

    ExceptionArea getArea();

    HttpStatus getHttpStatus();
}
