package cn.exercise.design_mode.chainOfResponsibility;

/**
 * 经理类
 */
public class CommonManager extends Manager{


    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if("请假".equals( request.getRequestType()) && request.getNumber()<=2){
            System.out.println( this.name + ":" +request.getRequestContent()+request.getNumber()+"天被批准");
        }else if(superior!=null){   //如果当前管理员不能处理该请求，交给上级处理
            superior.requestApplication(request);
        }

    }
}
