package com.legit.anomaly_detector.anomalies.detectors;

import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import com.legit.anomaly_detector.anomalies.events.team.TeamEvent;
import com.legit.anomaly_detector.common.exeptions.AppException;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.legit.anomaly_detector.common.consts.Consts.CREATED;


@Component
public class TeamNameAnomalyDetector implements Detector {

    private final List<String> forbiddenPrefixes = List.of("hacker");

    @Override
    public DetectionResult detect(GitHubEvent gitHubEvent) throws AppException {
        DetectionResult detectionResult = new DetectionResult();
        TeamEvent teamEvent = GitHubEvent.toTeamEvent(gitHubEvent);

        if (CREATED.equals(teamEvent.getAction()) && isAnomalousTeamName(teamEvent)) {
            detectionResult.setDetected(true);
            detectionResult.setMessageToNotify(getMessageToNotify(teamEvent));
        }

        return detectionResult;
    }

    private boolean isAnomalousTeamName(TeamEvent teamEvent) {
        boolean result = false;

        for (String forbiddenPrefix : forbiddenPrefixes) {
            if (teamEvent.getTeam().getName().startsWith(forbiddenPrefix)) {
                result = true;
                break;
            }
        }

        return result;
    }

    private String getMessageToNotify(TeamEvent teamEvent) {
        return "Anomaly Detected! A team with a name starting with a forbidden prefix has been created. Team name: " + teamEvent.getTeam().getName();
    }
}
