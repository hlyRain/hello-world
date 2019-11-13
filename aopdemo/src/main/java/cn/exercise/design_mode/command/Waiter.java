package cn.exercise.mode.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 服务员类
 */
public class Waiter {
    private List<Command> orders = new ArrayList<>();

    public void setOrder(Command command){

        orders.add(command);
        System.out.println("增加订单" +"b时间："+new Date().toString());

    }

    public void cancelOrder(Command command){

        orders.remove(command);
        System.out.println("取消订单："+command.toString()  +" 时间："+new Date().toString());
    }

    /**
     * 通知执行
     */
    public void notifyExecute(){
        for (Command command: orders
             ) {
            command.executeCommand();
        }
    }


}
