package ru.netology.javacore;

public class CmdRestore extends Cmd implements ICmd {
    public CmdRestore(Type type) {
        super(type);
    }

    @Override
    public void execute() {
        Cmd cmd = History.getInstance().pollLastCmd();
        if (cmd != null) {
            cmd.undo();
        }
    }
}