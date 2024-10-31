package com.legit.anomaly_detector.anomalies.events.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Push {
    @JsonProperty("pushed_at")
    private long pushedAt;
}
