package com.legit.GitHub_Anomaly_Detector.anomalies.events.repository;

import com.legit.GitHub_Anomaly_Detector.anomalies.events.GitHubEvent;
import lombok.Data;

@Data
public class RepositoryEvent extends GitHubEvent {
    String action;
    Repository repository;
}
