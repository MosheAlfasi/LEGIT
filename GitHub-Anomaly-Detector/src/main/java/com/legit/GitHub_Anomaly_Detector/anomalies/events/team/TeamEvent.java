package com.legit.GitHub_Anomaly_Detector.anomalies.events.team;

import com.legit.GitHub_Anomaly_Detector.anomalies.events.GitHubEvent;
import lombok.Data;

@Data
public class TeamEvent extends GitHubEvent {
    String action;
    private Team team;
}
