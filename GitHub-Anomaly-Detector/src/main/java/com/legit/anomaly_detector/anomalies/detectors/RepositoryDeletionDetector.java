package com.legit.anomaly_detector.anomalies.detectors;

import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import com.legit.anomaly_detector.anomalies.events.repository.RepositoryEvent;
import com.legit.anomaly_detector.common.exeptions.AppException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import static com.legit.anomaly_detector.common.consts.Consts.DELETED;

@Component
public class RepositoryDeletionDetector implements Detector {

    @Value("${min.delay.between.create.and.delete.minutes:10}")
    private int minDelayBetweenCreateAndDeleteMinutes;

    @Override
    public DetectionResult detect(GitHubEvent gitHubEvent) throws AppException {
        DetectionResult detectionResult = new DetectionResult();
        RepositoryEvent repositoryEvent = GitHubEvent.toRepositoryEvent(gitHubEvent);

       if (DELETED.equals(repositoryEvent.getAction()) && isRepoDeletedAnomalyDetection(repositoryEvent)) {
            detectionResult.setDetected(true);
            detectionResult.setMessageToNotify(getMessageToNotify(repositoryEvent));
        }

        return detectionResult;
    }

    private boolean isRepoDeletedAnomalyDetection(RepositoryEvent repositoryEvent) {
        Date cratedAt = repositoryEvent.getRepository().getCreatedAt();
        Date deletedAt = repositoryEvent.getRepository().getUpdatedAt();

        long differenceInMillis = deletedAt.getTime() - cratedAt.getTime();
        long differenceInMinutes = differenceInMillis / (1000 * 60);

        return differenceInMinutes < minDelayBetweenCreateAndDeleteMinutes;
    }

    private String getMessageToNotify(RepositoryEvent repositoryEvent) {
        return "Anomaly Detected! Repository was deleted and created in less than " + minDelayBetweenCreateAndDeleteMinutes + " minutes. Repository name: " + repositoryEvent.getRepository().getName();
    }
}







