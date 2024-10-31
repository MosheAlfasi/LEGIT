package com.legit.anomaly_detector.anomalies.enums;


import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import com.legit.anomaly_detector.anomalies.events.push.PushEvent;
import com.legit.anomaly_detector.anomalies.events.repository.RepositoryEvent;
import com.legit.anomaly_detector.anomalies.events.team.TeamEvent;
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
