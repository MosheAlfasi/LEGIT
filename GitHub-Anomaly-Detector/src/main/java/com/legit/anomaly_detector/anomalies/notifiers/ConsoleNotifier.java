package com.legit.anomaly_detector.anomalies.notifiers;

import com.legit.anomaly_detector.console.CommandLineApp;
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
