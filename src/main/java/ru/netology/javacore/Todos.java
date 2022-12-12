package ru.netology.javacore;

import java.util.*;

public class Todos {
    public static final int MAXSIZE = 7;
    private static Todos todos;
    private final Set<String> todosSet = new HashSet<>();

    public void addTask(String task) {
        if (todosSet.size() < MAXSIZE) {
            todosSet.add(task);
        }
    }

    public Todos() {
        todos = this;
    }

    public void removeTask(String task) {
        todosSet.remove(task);
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        todosSet.stream().sorted(Comparator.naturalOrder()).forEach(s -> sb.append(s).append(" "));
        return sb.toString().stripTrailing();
    }

    public static Todos getInstance() {
        return todos;
    }

    public boolean notFull() {
        return todosSet.size() < MAXSIZE;
    }
}