package cn.exercise.design_mode.observer;

/**
 * 看NBA的人
 */
public class NBAObserver implements Observer {
    private String name;
    private Subject sub;

    public NBAObserver(String name, Boss sub) {
        this.name = name;
        this.sub = sub;
    }


    public void update(Subject subject, Object data) {
        System.out.println();
        System.out.printf("%s %s 关闭NBA直播，继续工作！", data, name);
    }
}
