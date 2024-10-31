package com.legit.GitHub_Anomaly_Detector.anomalies.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "repositories")
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RepositoryEntity {
    @Id
    @Column(nullable = false, length = 40)
    private String id;

    @Column(nullable = false)
    private Date createdAt;
}
