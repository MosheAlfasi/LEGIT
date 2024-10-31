package com.legit.GitHub_Anomaly_Detector.anomalies.detectors;


import com.legit.GitHub_Anomaly_Detector.anomalies.entities.RepositoryEntity;
import com.legit.GitHub_Anomaly_Detector.anomalies.events.GitHubEvent;
import com.legit.GitHub_Anomaly_Detector.anomalies.events.repository.RepositoryEvent;
import com.legit.GitHub_Anomaly_Detector.anomalies.repositories.GitRepositoryRepo;
import com.legit.GitHub_Anomaly_Detector.common.exeptions.AppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

import static com.legit.GitHub_Anomaly_Detector.common.consts.Consts.CREATED;
import static com.legit.GitHub_Anomaly_Detector.common.consts.Consts.DELETED;


@Component
@AllArgsConstructor
public class RepositoryDeletionDetector implements Detector {
    private final GitRepositoryRepo gitRepositoryRepo;

    @Override
    public DetectionResult detect(GitHubEvent gitHubEvent) throws AppException {
        DetectionResult detectionResult = new DetectionResult();
        RepositoryEvent repositoryEvent = GitHubEvent.toRepositoryEvent(gitHubEvent);

        if (CREATED.equals(repositoryEvent.getAction())) {
            storeRepository(repositoryEvent);

        } else if (DELETED.equals(repositoryEvent.getAction()) && isRepoDeletedAnomalyDetection(repositoryEvent)) {
            detectionResult.setDetected(true);
            detectionResult.setMessageToNotify(getMessageToNotify(repositoryEvent));
        }

        return detectionResult;
    }

    private boolean isRepoDeletedAnomalyDetection(RepositoryEvent repositoryEvent) {
        boolean isDetected = false;
        Optional<RepositoryEntity> repositoryEntityOptional = gitRepositoryRepo.findById(repositoryEvent.getRepository().getId());

        if (repositoryEntityOptional.isPresent()) {
            RepositoryEntity repositoryEntity = repositoryEntityOptional.get();
            Date createdAt = repositoryEntity.getCreatedAt();
            Date deletedAt = repositoryEvent.getRepository().getUpdatedAt();
            long differenceInMillis = deletedAt.getTime() - createdAt.getTime();
            long differenceInMinutes = differenceInMillis / (1000 * 60);

            isDetected = differenceInMinutes < 10;
        }

        return isDetected;
    }

    private void storeRepository(RepositoryEvent repositoryEvent) {
        RepositoryEntity repositoryEntity = RepositoryEntity.builder()
                .id(repositoryEvent.getRepository().getId())
                .createdAt(repositoryEvent.getRepository().getCreatedAt())
                .build();

        gitRepositoryRepo.save(repositoryEntity);
    }

    private String getMessageToNotify(RepositoryEvent repositoryEvent) {
        return "Anomaly Detected! Repository was deleted and created in less than 10 minutes. Repository name: " + repositoryEvent.getRepository().getName();
    }
}







