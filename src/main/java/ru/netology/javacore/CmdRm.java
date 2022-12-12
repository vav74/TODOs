package ru.netology.javacore;

public class CmdRm extends Cmd implements ICmd {

    public CmdRm(Type type, String task) {
        super(type, task);
    }

    @Override
    public void execute() {
        History.getInstance().add(this);
        Todos.getInstance().removeTask(task);
    }

    @Override
    public void undo() {
        Todos.getInstance().addTask(task);
    }
}