package com.legit.anomaly_detector.anomalies.events;

import com.legit.anomaly_detector.anomalies.events.push.PushEvent;
import com.legit.anomaly_detector.anomalies.events.repository.RepositoryEvent;
import com.legit.anomaly_detector.anomalies.events.team.TeamEvent;
import com.legit.anomaly_detector.anomalies.exeptions.AnomalyDetectorErrMsg;
import com.legit.anomaly_detector.common.exeptions.AppException;
import lombok.Data;

@Data
public class GitHubEvent {
    public static TeamEvent toTeamEvent(GitHubEvent gitHubEvent) throws AppException {
        if (gitHubEvent instanceof TeamEvent teamEvent) {
            return teamEvent;
        } else {
            throw new AppException(AnomalyDetectorErrMsg.FAILED_CAST_GIT_HUB_EVENT_TO, TeamEvent.class.getName(), gitHubEvent.toString());
        }
    }

    public static RepositoryEvent toRepositoryEvent(GitHubEvent gitHubEvent) throws AppException {
        if (gitHubEvent instanceof RepositoryEvent repositoryEvent) {
            return repositoryEvent;
        } else {
            throw new AppException(AnomalyDetectorErrMsg.FAILED_CAST_GIT_HUB_EVENT_TO, RepositoryEvent.class.getName(), gitHubEvent.toString());
        }
    }

    public static PushEvent toPushEvent(GitHubEvent gitHubEvent) throws AppException {
        if (gitHubEvent instanceof PushEvent pushEvent) {
            return pushEvent;
        } else {
            throw new AppException(AnomalyDetectorErrMsg.FAILED_CAST_GIT_HUB_EVENT_TO, PushEvent.class.getName(), gitHubEvent.toString());
        }
    }
}
