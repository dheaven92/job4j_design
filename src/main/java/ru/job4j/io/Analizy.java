package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    public void unavailable(String source, String target) {
        List<String> intervals = readIntervalsFromLogFile(source);
        writeIntervalsToFile(intervals, target);
    }

    private List<String> readIntervalsFromLogFile(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            List<String> intervals = new ArrayList<>();
            String startTime = null;
            String endTime;
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                LogLine logLine = getLogLine(line);
                if (startTime == null && (logLine.status.equals("400") || logLine.status.equals("500"))) {
                    startTime = logLine.time;
                }
                if (startTime != null && (logLine.status.equals("200") || logLine.status.equals("300"))) {
                    endTime = logLine.time;
                    intervals.add(String.format("%s;%s;", startTime, endTime));
                    startTime = null;
                }
            }
            return intervals;
        } catch (Exception e) {
            throw new RuntimeException("Could not process log file " + source);
        }
    }

    private LogLine getLogLine(String line) {
        try {
            String[] parts = line.split("\\s");
            return new LogLine(parts[0], parts[1]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Invalid file format");
        }
    }

    private static class LogLine {
        String status;
        String time;

        LogLine(String status, String time) {
            this.status = status;
            this.time = time;
        }
    }

    private void writeIntervalsToFile(List<String> intervals, String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            intervals.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analizy().unavailable("./data/server.log", "unavailable.csv");
    }
}
