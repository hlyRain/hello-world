package cn.exercise.mode.singleton.hungry;

/**
 * 单例模式，饿汉模式
 * private final关键字修饰
 */
public class Single {

    private static final Single s = new Single();

    private Single() {
    }

    public static Single getInstance() {
        return s;
    }
}
