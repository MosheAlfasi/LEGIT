package com.legit.GitHub_Anomaly_Detector.anomalies.events.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Repository {
    private String id;
    private String name;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
}
