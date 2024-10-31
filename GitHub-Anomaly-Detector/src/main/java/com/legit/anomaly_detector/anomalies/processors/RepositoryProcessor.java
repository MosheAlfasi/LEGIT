package com.legit.anomaly_detector.anomalies.processors;


import com.legit.anomaly_detector.anomalies.detectors.RepositoryDeletionDetector;
import com.legit.anomaly_detector.anomalies.notifiers.ConsoleNotifier;
import com.legit.anomaly_detector.anomalies.rule.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RepositoryProcessor extends Processor {
    private final RepositoryDeletionDetector repositoryDeletionDetector;
    private final ConsoleNotifier consoleNotifier;

    @Override
    protected void initRules() {
        rules.add(new Rule(repositoryDeletionDetector, List.of(consoleNotifier)));
    }
}
