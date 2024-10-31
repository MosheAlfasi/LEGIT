package com.legit.GitHub_Anomaly_Detector.anomalies.processors;

import com.legit.GitHub_Anomaly_Detector.anomalies.detectors.TeamNameAnomalyDetector;
import com.legit.GitHub_Anomaly_Detector.anomalies.notifiers.ConsoleNotifier;
import com.legit.GitHub_Anomaly_Detector.anomalies.rule.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TeamProcessor extends Processor {
    private final TeamNameAnomalyDetector teamNameAnomalyDetector;
    private final ConsoleNotifier consoleNotifier;

    @Override
    protected void initRules() {
        rules.add(new Rule(teamNameAnomalyDetector, List.of(consoleNotifier)));
    }
}
