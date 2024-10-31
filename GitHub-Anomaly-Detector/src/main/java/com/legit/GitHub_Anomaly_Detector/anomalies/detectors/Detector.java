package com.legit.GitHub_Anomaly_Detector.anomalies.detectors;


import com.legit.GitHub_Anomaly_Detector.anomalies.events.GitHubEvent;
import com.legit.GitHub_Anomaly_Detector.common.exeptions.AppException;

public interface Detector {
    DetectionResult detect(GitHubEvent event) throws AppException;
}
