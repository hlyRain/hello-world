package cn.exercise.mode.singleton.double_lock;


/**
 * 单例模式
 * 双重校验锁法
 */
public class SingletonDemo {
    private static SingletonDemo instance;

    private SingletonDemo() {
        System.out.println("Singleton has loaded");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
        