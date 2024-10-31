package com.legit.GitHub_Anomaly_Detector.anomalies.detectors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetectionResult {
    private boolean isDetected = false;
    private String messageToNotify = "";
}
