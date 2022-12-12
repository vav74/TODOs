package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {
    private Todos todos;

    @BeforeEach
    void setUp() {
        todos = new Todos();
    }

    @Test
    void addTaskTest() {
        final String argument1 = "Заснуть в 01";
        final String argument2 = "Проснуться в 02";
        final String expected = "Заснуть в 01 Проснуться в 02";
        todos.addTask(argument1);
        todos.addTask(argument2);
        String result = todos.getAllTasks();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void removeTaskTest() {
        final String argument1 = "Заснуть в 05";
        final String argument2 = "Проснуться в 06";
        final String expected = "Проснуться в 06";
        todos.addTask(argument1);
        todos.addTask(argument2);
        todos.removeTask(argument1);
        String result = todos.getAllTasks();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getAllTasksTest() {
        final String argument1 = "Проснуться в 10";
        final String argument2 = "Заснуть в 02";
        final String argument3 = "Проснуться в 09";
        final String argument4 = "Заснуть в 01";

        final String expected = "Заснуть в 01 Заснуть в 02 Проснуться в 09 Проснуться в 10";
        todos.addTask(argument1);
        todos.addTask(argument2);
        todos.addTask(argument3);
        todos.addTask(argument4);
        String result = todos.getAllTasks();
        Assertions.assertEquals(expected, result);
    }
}