package cn.exercise.design_mode.mediator;

public class Iraq extends Country {
    public Iraq(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String message){
        mediator.declare(message,this);
    }

    public void getMessage(String message){
        System.out.println("伊拉克获得对方消息："+message);
    }
}
