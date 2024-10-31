package com.legit.anomaly_detector.anomalies.detectors;

import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import com.legit.anomaly_detector.anomalies.events.push.PushEvent;
import com.legit.anomaly_detector.common.exeptions.AppException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class PushInForbiddenTimeDetector implements Detector {

    @Value("${start.forbidden.hour:14}")
    private int startForbiddenHour;
    @Value("${end.forbidden.hour:16}")
    private int endForbiddenHour;

    @Override
    public DetectionResult detect(GitHubEvent event) throws AppException {
        DetectionResult detectionResult = new DetectionResult();
        PushEvent pushEvent = GitHubEvent.toPushEvent(event);

        if (isPushDuringRestrictedHours(pushEvent)) {
            detectionResult.setDetected(true);
            detectionResult.setMessageToNotify(getMessageToNotify(pushEvent));
        }

        return detectionResult;
    }

    private boolean isPushDuringRestrictedHours (PushEvent pushEvent) {
        long timestamp = pushEvent.getPush().getPushedAt();

        return isTimeStampBetweenHours(timestamp, startForbiddenHour, endForbiddenHour);
    }

    private boolean isTimeStampBetweenHours(long timestamp, int startHour, int endHour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timestamp * 1000));

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        return (hour >= startHour && hour < endHour) || (hour == endHour && minute == 0);
    }

    private String getMessageToNotify(PushEvent pushEvent) {
        return "Anomaly Detected! Code pushed between 14:00 to 16:00. pushed at: " + new Date(pushEvent.getPush().getPushedAt());
    }
}
