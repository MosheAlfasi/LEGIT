package com.legit.GitHub_Anomaly_Detector.anomalies.notifiers;

import com.legit.GitHub_Anomaly_Detector.console.CommandLineApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsoleNotifier implements Notifier {
    private final CommandLineApp commandLineApp;

    @Override
    public void notify(String message) {
        commandLineApp.printMessage(message);
    }
}
