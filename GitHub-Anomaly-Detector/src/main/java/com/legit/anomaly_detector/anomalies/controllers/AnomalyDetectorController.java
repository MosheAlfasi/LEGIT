package com.legit.anomaly_detector.anomalies.controllers;

import com.legit.anomaly_detector.anomalies.enums.EventType;
import com.legit.anomaly_detector.anomalies.services.AnomalyDetectorService;
import com.legit.anomaly_detector.common.exeptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.legit.anomaly_detector.common.consts.Consts.X_GITHUB_EVENT_HEADER;


@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor
public class AnomalyDetectorController {
    private final AnomalyDetectorService service;

    @PostMapping()
    public ResponseEntity<String> handleEvent(@RequestBody String eventPayload, @RequestHeader(name = X_GITHUB_EVENT_HEADER) EventType eventType) throws AppException {
        service.handleEvent(eventPayload, eventType);

        return new ResponseEntity<>("Event handled successfully!", HttpStatus.OK);
    }
}
