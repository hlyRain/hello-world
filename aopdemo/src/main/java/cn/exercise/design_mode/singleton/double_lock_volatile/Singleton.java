package cn.exercise.design_mode.singleton.double_lock_volatile;


/**
 *
 */
public class Singleton {
    private volatile static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}