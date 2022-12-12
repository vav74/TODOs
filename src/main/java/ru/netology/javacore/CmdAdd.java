package ru.netology.javacore;

public class CmdAdd extends Cmd implements ICmd {
    public CmdAdd(Type type, String task) {
        super(type, task);
    }

    @Override
    public void execute() {
        if (Todos.getInstance().notFull()) {
            History.getInstance().add(this);
            Todos.getInstance().addTask(task);
        }
    }

    @Override
    public void undo() {
        Todos.getInstance().removeTask(task);
    }
}