package cn.exercise.mode.observer1;

/**
 * 观察者模式,又称 发布 - 订阅模式（）Publish/Subscribe模式,增加事件委托机制 ，使用反射机制执行委托方法
 */
public class ObserverMain {

    public static void main(String[] args) {
        notifyListener();
    }


    public static void notifyListener() {
        //创建一个尽职尽责的放哨者
        Notifier bossNotifier = new BossNotifier();

        //创建一个看NBA直播的同学，开始看直播
        NBAListener nbaListener = new NBAListener("张三");

        //创建一个看股票的员工，开始看股票
        StockListener stockListener = new StockListener("李四");
        //看NBA直播告诉放哨的员工，老板来了告诉一下，委托事件为closeNBA(String msg)
        bossNotifier.addListener(nbaListener, "closeNBA", "老板来了");
        //看股票的同学告诉放哨的同学，老板来了告诉一下,委托事件为closeStock(String msg)
        bossNotifier.addListener(stockListener, "closeStock", "老板来了");
        try {
            //一点时间后
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //老师出现，放哨的人通知所有要帮忙的同学:老师来了
        bossNotifier.notifyX();
    }
}
