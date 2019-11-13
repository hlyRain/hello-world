package cn.exercise.design_mode.command;


/**
 * 烤鱼串命令
 */
public class BakeFishCommand extends Command {

    public BakeFishCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void executeCommand() {
        receiver.bakeFish();
    }
}
