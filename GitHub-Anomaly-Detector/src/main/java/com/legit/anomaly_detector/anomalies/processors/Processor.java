package com.legit.anomaly_detector.anomalies.processors;

import com.legit.anomaly_detector.anomalies.events.GitHubEvent;
import com.legit.anomaly_detector.anomalies.rule.Rule;
import com.legit.anomaly_detector.common.exeptions.AppException;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

public abstract class Processor {
    protected final List<Rule> rules = new ArrayList<>();

    @PostConstruct
    public void init() {
        initRules();
    }

    public void processEvent(GitHubEvent gitHubEvent) throws AppException {
        for (Rule rule : rules) {
            rule.detectAndNotify(gitHubEvent);
        }
    }

    protected abstract void initRules();
}
