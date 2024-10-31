package com.legit.GitHub_Anomaly_Detector.anomalies.enums;


import com.legit.GitHub_Anomaly_Detector.anomalies.events.GitHubEvent;
import com.legit.GitHub_Anomaly_Detector.anomalies.events.push.PushEvent;
import com.legit.GitHub_Anomaly_Detector.anomalies.events.repository.RepositoryEvent;
import com.legit.GitHub_Anomaly_Detector.anomalies.events.team.TeamEvent;
import lombok.Getter;

@Getter
public enum EventType {
    team(TeamEvent.class),
    repository(RepositoryEvent.class),
    push(PushEvent.class);

    private final Class<? extends GitHubEvent> gitHubEventClazz;

    EventType(Class<? extends GitHubEvent> clazz) {
        gitHubEventClazz = clazz;
    }
}
