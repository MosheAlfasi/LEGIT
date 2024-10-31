package com.legit.GitHub_Anomaly_Detector.anomalies.events.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.legit.GitHub_Anomaly_Detector.anomalies.events.GitHubEvent;
import lombok.Data;

@Data
public class PushEvent extends GitHubEvent {
    @JsonProperty("repository")
    Push push;
}
