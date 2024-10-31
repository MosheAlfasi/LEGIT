package com.legit.anomaly_detector.anomalies.detectors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetectionResult {
    private boolean isDetected = false;
    private String messageToNotify = "";
}
