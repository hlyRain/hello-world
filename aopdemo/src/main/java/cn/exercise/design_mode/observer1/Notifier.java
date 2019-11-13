package cn.exercise.mode.observer1;


import java.util.ArrayList;
import java.util.List;

public abstract class Notifier {
    public List<Event> eventList = new ArrayList<>();


    public abstract void addListener(Object object,String methodName,Object... args);
    public abstract void notifyX();

}
