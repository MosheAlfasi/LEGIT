package com.legit.anomaly_detector.anomalies.exeptions;

import com.legit.anomaly_detector.common.exeptions.ExceptionArea;
import com.legit.anomaly_detector.common.exeptions.GeneralErrMsg;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum AnomalyDetectorErrMsg implements GeneralErrMsg {
    INVALID_EVENT_TYPE("Event type is not supported. Event type: %s", HttpStatus.BAD_REQUEST),
    INVALID_PAYLOAD("Event payload is not supported. Event payload: %s", HttpStatus.BAD_REQUEST),
    FAILED_CAST_GIT_HUB_EVENT_TO("Failed to cast GitHub event to %s. Event: %s", HttpStatus.BAD_REQUEST);

    final String msg;
    final ExceptionArea area;
    final HttpStatus httpStatus;

    AnomalyDetectorErrMsg(String msg, HttpStatus httpStatus) {
        this.msg = msg;
        this.httpStatus = httpStatus;
        this.area = ExceptionArea.ANOMALY_DETECTION;
    }
}
