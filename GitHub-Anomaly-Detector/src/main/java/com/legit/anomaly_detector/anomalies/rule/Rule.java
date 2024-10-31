package com.legit.anomaly_detector.anomalies.rule;

import com.legit.anomaly_detector.anomalies.detectors.DetectionResult;
import com.legit.anomaly_detector.anomalies.detectors.Detector;
import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import com.legit.anomaly_detector.anomalies.notifiers.Notifier;
import com.legit.anomaly_detector.common.exeptions.AppException;
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
