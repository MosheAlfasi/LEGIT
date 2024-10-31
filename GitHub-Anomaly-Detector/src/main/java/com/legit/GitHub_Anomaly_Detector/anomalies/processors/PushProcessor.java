package com.legit.GitHub_Anomaly_Detector.anomalies.processors;

import com.legit.GitHub_Anomaly_Detector.anomalies.detectors.PushInForbiddenTimeDetector;
import com.legit.GitHub_Anomaly_Detector.anomalies.notifiers.ConsoleNotifier;
import com.legit.GitHub_Anomaly_Detector.anomalies.rule.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PushProcessor extends Processor {
    private final PushInForbiddenTimeDetector pushInForbiddenTimeDetector;
    private final ConsoleNotifier consoleNotifier;

    @Override
    protected void initRules() {
        rules.add(new Rule(pushInForbiddenTimeDetector, List.of(consoleNotifier)));
    }
}
