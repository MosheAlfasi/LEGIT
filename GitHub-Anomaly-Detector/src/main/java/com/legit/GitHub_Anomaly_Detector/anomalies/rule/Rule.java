package com.legit.GitHub_Anomaly_Detector.anomalies.rule;

import com.legit.GitHub_Anomaly_Detector.anomalies.detectors.DetectionResult;
import com.legit.GitHub_Anomaly_Detector.anomalies.detectors.Detector;
import com.legit.GitHub_Anomaly_Detector.anomalies.events.GitHubEvent;
import com.legit.GitHub_Anomaly_Detector.anomalies.notifiers.Notifier;
import com.legit.GitHub_Anomaly_Detector.common.exeptions.AppException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Rule {
    private Detector detector;
    List<Notifier> notifiers;

    public void detectAndNotify(GitHubEvent gitHubEvent) throws AppException {
        DetectionResult detectionResult = detector.detect(gitHubEvent);

        if (detectionResult.isDetected()) {
            String message = detectionResult.getMessageToNotify();

            notifiers.forEach(notifier ->
                    notifier.notify(message));
        }
    }
}
