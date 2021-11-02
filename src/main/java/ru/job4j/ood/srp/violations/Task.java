package ru.job4j.ood.srp.violations;

import java.time.LocalDateTime;

public class Task {

    private String title;

    private LocalDateTime deadline;

    public Task(String title, LocalDateTime deadline) {
        this.title = title;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task{"
                + "title='" + title + '\''
                + ", deadline=" + deadline
                + '}';
    }
}
