package com.legit.anomaly_detector.anomalies.events.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import lombok.Data;

@Data
public class PushEvent extends GitHubEvent {
    @JsonProperty("repository")
    Push push;
}
