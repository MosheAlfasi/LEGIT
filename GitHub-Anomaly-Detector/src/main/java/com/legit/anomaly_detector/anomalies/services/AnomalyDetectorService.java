package com.legit.anomaly_detector.anomalies.services;


import com.legit.anomaly_detector.anomalies.enums.EventType;
import com.legit.anomaly_detector.common.exeptions.AppException;

public interface AnomalyDetectorService {
    void handleEvent(String eventPayload, EventType eventType) throws AppException;
}
