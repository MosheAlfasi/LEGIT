package com.legit.GitHub_Anomaly_Detector.anomalies.repositories;


import com.legit.GitHub_Anomaly_Detector.anomalies.entities.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GitRepositoryRepo extends JpaRepository<RepositoryEntity, String> {
}
