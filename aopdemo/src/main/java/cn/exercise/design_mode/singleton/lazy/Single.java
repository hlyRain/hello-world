package cn.exercise.design_mode.singleton.lazy;

/**
 * 单例模式，懒汉模式
 */
public class Single {

    /**
     * 这里没有final关键字修饰
     */
    private static Single s = null;

    private Single() {
    }

    public static Single getInstance() {
        if(s==null){
            s = new Single();
        }
        return s;
    }
}
