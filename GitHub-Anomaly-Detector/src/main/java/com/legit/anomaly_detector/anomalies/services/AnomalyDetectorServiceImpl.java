package com.legit.anomaly_detector.anomalies.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.legit.anomaly_detector.anomalies.enums.EventType;
import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import com.legit.anomaly_detector.anomalies.exeptions.AnomalyDetectorErrMsg;
import com.legit.anomaly_detector.anomalies.processors.Processor;
import com.legit.anomaly_detector.anomalies.processors.ProcessorFactory;
import com.legit.anomaly_detector.common.exeptions.AppException;
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
