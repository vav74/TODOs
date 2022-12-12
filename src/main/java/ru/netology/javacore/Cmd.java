package ru.netology.javacore;

public class Cmd implements ICmd {
    public enum Type {
        ADD,
        REMOVE,
        RESTORE
    }

    protected Type type;
    protected String task = "";

    public Cmd(Type type, String task) {
        this.type = type;
        this.task = task;
    }

    public Cmd(Type type) {
        this.type = type;
    }

    public void execute() {
        switch (type) {
            case ADD:
                new CmdAdd(type, task).execute();
                break;
            case REMOVE:
                new CmdRm(type, task).execute();
                break;
            case RESTORE:
                new CmdRestore(type).execute();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    @Override
    public void undo() {
    }
}
