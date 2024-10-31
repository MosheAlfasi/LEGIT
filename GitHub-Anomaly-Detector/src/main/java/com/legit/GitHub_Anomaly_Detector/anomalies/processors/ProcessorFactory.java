package com.legit.GitHub_Anomaly_Detector.anomalies.processors;

import com.legit.GitHub_Anomaly_Detector.anomalies.enums.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProcessorFactory {
    private final TeamProcessor teamProcessor;
    private final PushProcessor pushProcessor;
    private final RepositoryProcessor repositoryProcessor;

    public Processor getProcessorByEventType(EventType eventType) {
        return switch (eventType) {
            case team -> teamProcessor;
            case repository -> repositoryProcessor;
            case push -> pushProcessor;
        };
    }
}
