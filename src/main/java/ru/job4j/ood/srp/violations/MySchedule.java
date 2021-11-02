package ru.job4j.ood.srp.violations;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class MySchedule implements Scheduler {

    private static final List<Task> DEFAULT_SCHEDULE = new LinkedList<>();

    private final Notifier notifier;

    public MySchedule(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void setDefaultSchedule() {
        List<Task> tasks = List.of(
                new Task("wake up", LocalDateTime.now()),
                new Task("have breakfast", LocalDateTime.now())
        );
        tasks.forEach(task -> task.setDeadline(task.getDeadline().plusDays(1)));
        DEFAULT_SCHEDULE.addAll(tasks);
        tasks.forEach(notifier::notify);
    }
}
