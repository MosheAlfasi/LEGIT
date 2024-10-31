package com.legit.GitHub_Anomaly_Detector.common.exeptions;

import lombok.Getter;

@Getter
public enum ExceptionArea {
    GENERAL("General"),
    ANOMALY_DETECTION("Anomaly Detection");

    final String areaName;

    ExceptionArea(String areaName) {
        this.areaName = areaName;
    }
}
