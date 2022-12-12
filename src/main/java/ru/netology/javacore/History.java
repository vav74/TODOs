package ru.netology.javacore;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {
    private final Deque<Cmd> historyDeque = new ArrayDeque<>();
    private static History history;

    private History() {
    }

    public static History getInstance() {
        if (history == null) {
            history = new History();
        }
        return history;
    }

    public void add(Cmd cmd) {
        historyDeque.add(cmd);
    }

    public Cmd pollLastCmd() {
        return historyDeque.pollLast();
    }
}