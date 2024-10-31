package com.legit.GitHub_Anomaly_Detector.anomalies.services;


import com.legit.GitHub_Anomaly_Detector.anomalies.enums.EventType;
import com.legit.GitHub_Anomaly_Detector.common.exeptions.AppException;

public interface AnomalyDetectorService {
    void handleEvent(String eventPayload, EventType eventType) throws AppException;
}
