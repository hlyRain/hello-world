package cn.exercise.mode.observer;

/**
 * 看股票的人
 */
public class StockObserver implements Observer{
    private String  name ;
    private Subject sub;

    public StockObserver(String name, Subject sub) {
        this.name = name;
        this.sub = sub;
    }

    @Override
    public void update(Subject subject,Object data){
        System.out.println();
        System.out.printf("%s %s 关闭股票行情，继续工作！", data,name);
    }

}
