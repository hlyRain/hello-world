package cn.exercise.design_mode.command;


/**
 * 命令模式
 * 需求方Command 不定时发送命令，
 * 命令收集方（Waiter）不断收集需求，
 * 处理方（Barbecuer） 处理需求
 *
 */
public class CommandMain {

    public static void main(String[] args) {
        Barbecuer boy = new Barbecuer();
        Command bakeMuttonCommand1 = new BakeMuttonCommand(boy);
        Command bakeMuttonCommand2 = new BakeMuttonCommand(boy);
        Command bakeFishCommand1 = new BakeFishCommand(boy);

        Waiter girl = new Waiter();
        girl.setOrder(bakeMuttonCommand1);
        girl.setOrder(bakeMuttonCommand2);
        girl.setOrder(bakeFishCommand1);

        girl.notifyExecute();


    }

}
