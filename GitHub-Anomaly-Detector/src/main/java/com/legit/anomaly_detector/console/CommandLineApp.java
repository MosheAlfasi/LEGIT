package com.legit.anomaly_detector.console;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineApp implements CommandLineRunner {

    @Override
    public void run(String... args) {
        startCommandLineInterface();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void startCommandLineInterface() {
        System.out.println("Welcome to the GitHub Anomaly Detector App. Here we will print all the anomalies activities detected by our app:");
        System.out.println("In order to see the application logs, open the /logs/log.txt file.\n");
    }
}
