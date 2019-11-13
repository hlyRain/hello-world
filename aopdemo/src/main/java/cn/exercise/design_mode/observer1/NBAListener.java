package cn.exercise.design_mode.observer1;

/**
 * 看NBA的人
 */
public class NBAListener {
    private String name;

    public NBAListener(String name) {
        this.name = name;
    }


    public void closeNBA(String msg) {
        System.out.println();
        System.out.printf("%s %s 关闭NBA直播，继续工作！", msg, name);
    }
}
