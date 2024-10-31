package com.legit.anomaly_detector.anomalies.events.repository;

import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import lombok.Data;

@Data
public class RepositoryEvent extends GitHubEvent {
    String action;
    Repository repository;
}
