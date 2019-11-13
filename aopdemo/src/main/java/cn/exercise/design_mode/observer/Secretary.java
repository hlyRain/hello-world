package cn.exercise.design_mode.observer;

import java.util.ArrayList;
import java.util.List;

public class Secretary implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String action;

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }
    public void notifyObs(){
        for (Observer obs:observers
             ) {
            obs.update(this,action);
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
