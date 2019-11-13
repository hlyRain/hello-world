package cn.exercise.design_mode.observer;

/**
 * 观察者模式,又称 发布 - 订阅模式（）Publish/Subscribe模式
 */
public class ObserverMain {

    public static void main(String[] args) {
        Boss dinghan = new Boss();
        Observer tongshi1 = new StockObserver("张三",dinghan);
        Observer tongshi2 = new NBAObserver("李四",dinghan);

        dinghan.attach(tongshi1);
        dinghan.attach(tongshi2);

//        dinghan.detach(tongshi2);

        dinghan.setSubjectState("我丁汉回来了");
        dinghan.notifyObs();
    }


}
