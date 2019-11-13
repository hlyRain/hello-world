package cn.exercise.mode.chainOfResponsibility;

/**
 * 总经理类
 */
public class GeneralManager extends Manager{


    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if("请假".equals( request.getRequestType()) ){
            System.out.println( this.name + ":" +request.getRequestContent()+request.getNumber()+"天被批准");
        }else if("加薪".equals( request.getRequestType()) && request.getNumber()<=1000){   //如果当前管理员不能处理该请求，交给上级处理
            System.out.println( this.name + ":" +request.getRequestContent()+request.getNumber()+"被批准");
        }else if("加薪".equals( request.getRequestType()) && request.getNumber()>1000){   //如果当前管理员不能处理该请求，交给上级处理
            System.out.println( this.name + ":" +request.getRequestContent()+request.getNumber()+" 再说吧！");
        }

    }
}
