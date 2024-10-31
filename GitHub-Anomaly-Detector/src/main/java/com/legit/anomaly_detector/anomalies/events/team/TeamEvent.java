package com.legit.anomaly_detector.anomalies.events.team;

import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import lombok.Data;

@Data
public class TeamEvent extends GitHubEvent {
    String action;
    private Team team;
}
