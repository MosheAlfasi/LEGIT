package com.legit.anomaly_detector.anomalies.detectors;


import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import com.legit.anomaly_detector.common.exeptions.AppException;

public interface Detector {
    DetectionResult detect(GitHubEvent event) throws AppException;
}
