package cn.exercise.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用run运行会陷入死循环，使用debug模式运行该方法
 *
 */
public class VolatileTest {

    public static volatile AtomicInteger race = new AtomicInteger(0);

    private static void increase(){
        race.getAndIncrement();
    }

    public static  final int THREADE_COUNT = 20;



    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADE_COUNT];
        for(int i=0;i<THREADE_COUNT;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j<10000; j++){
                        increase();
//                        System.out.println("Thread " +j +" is running ");
                    }
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount()>1){
//            Thread.currentThread().getThreadGroup().list();
//            System.out.println("Thread " +" is running ");
            Thread.yield();
        }
        System.out.println(race);

    }
}
