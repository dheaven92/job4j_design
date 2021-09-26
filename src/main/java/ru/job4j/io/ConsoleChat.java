package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {

    private final String logPath;
    private final String botAnswersPath;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String logPath, String botAnswersPath) {
        this.logPath = logPath;
        this.botAnswersPath = botAnswersPath;
    }

    public void run() {
        List<String> botAnswers = readPhrases();
        List<String> logs = new ArrayList<>();
        boolean isAppRunning = true;
        boolean isBotRunning = true;
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Задай вопрос:");
        while (isAppRunning) {
            String question = in.nextLine();
            logs.add(question);
            if (question.equals(OUT)) {
                isAppRunning = false;
            }
            if (question.equals(STOP)) {
                isBotRunning = false;
            }
            if (question.equals(CONTINUE)) {
                isBotRunning = true;
            }
            if (isBotRunning && isAppRunning) {
                String answer = botAnswers.get(random.nextInt(botAnswers.size()));
                System.out.println(answer);
                logs.add(answer);
            }
        }
        saveLog(logs);
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswersPath))) {
            in.lines().forEach(answers::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> logs) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(logPath, StandardCharsets.UTF_8, true))
        ) {
            logs.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/bot-log.txt", "./data/bot-answers.txt");
        cc.run();
    }
}
