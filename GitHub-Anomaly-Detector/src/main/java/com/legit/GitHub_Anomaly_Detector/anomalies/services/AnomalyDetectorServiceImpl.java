package com.legit.GitHub_Anomaly_Detector.anomalies.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.legit.GitHub_Anomaly_Detector.anomalies.enums.EventType;
import com.legit.GitHub_Anomaly_Detector.anomalies.events.GitHubEvent;
import com.legit.GitHub_Anomaly_Detector.anomalies.exeptions.AnomalyDetectorErrMsg;
import com.legit.GitHub_Anomaly_Detector.anomalies.processors.Processor;
import com.legit.GitHub_Anomaly_Detector.anomalies.processors.ProcessorFactory;
import com.legit.GitHub_Anomaly_Detector.common.exeptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnomalyDetectorServiceImpl implements AnomalyDetectorService {

    private final ProcessorFactory processorFactory;
    private final ObjectMapper objectMapper;

    @Override
    public void handleEvent(String eventPayload, EventType eventType) throws AppException {
        GitHubEvent gitHubEvent = getGitHubEventByEventType(eventPayload, eventType);
        Processor processor = processorFactory.getProcessorByEventType(eventType);

        processor.processEvent(gitHubEvent);
    }

    private GitHubEvent getGitHubEventByEventType(String payload, EventType eventType) throws AppException {
        try {
            return objectMapper.readValue(payload, eventType.getGitHubEventClazz());
        } catch (Exception e) {
            throw new AppException(AnomalyDetectorErrMsg.INVALID_PAYLOAD, payload);
        }
    }
}
