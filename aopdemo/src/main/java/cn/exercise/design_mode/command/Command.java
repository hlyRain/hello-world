package cn.exercise.design_mode.command;

/**
 * 命令类
 */
public abstract class Command {

    protected Barbecuer receiver;

    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    public abstract void executeCommand();


}
