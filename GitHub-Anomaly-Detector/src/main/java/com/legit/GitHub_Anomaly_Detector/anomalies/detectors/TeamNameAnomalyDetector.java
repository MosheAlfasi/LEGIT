package com.legit.GitHub_Anomaly_Detector.anomalies.detectors;


import com.legit.GitHub_Anomaly_Detector.anomalies.events.GitHubEvent;
import com.legit.GitHub_Anomaly_Detector.anomalies.events.team.TeamEvent;
import com.legit.GitHub_Anomaly_Detector.common.exeptions.AppException;
import org.springframework.stereotype.Component;

import static com.legit.GitHub_Anomaly_Detector.common.consts.Consts.CREATED;


@Component
public class TeamNameAnomalyDetector implements Detector {

    @Override
    public DetectionResult detect(GitHubEvent gitHubEvent) throws AppException {
        DetectionResult detectionResult = new DetectionResult();
        TeamEvent teamEvent = GitHubEvent.toTeamEvent(gitHubEvent);

        if (CREATED.equals(teamEvent.getAction()) && isTeamNameAnomalyDetection(teamEvent)) {
            detectionResult.setDetected(true);
            detectionResult.setMessageToNotify(getMessageToNotify(teamEvent));
        }

        return detectionResult;
    }

    private boolean isTeamNameAnomalyDetection(TeamEvent teamEvent) {
        return teamEvent.getTeam().getName().startsWith("hacker");
    }

    private String getMessageToNotify(TeamEvent teamEvent) {
        return "Anomaly Detected! A team with a name starting with 'hacker' has been created. Team name: " + teamEvent.getTeam().getName();
    }
}
