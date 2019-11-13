package cn.exercise.design_mode.observer;

import java.util.ArrayList;
import java.util.List;

public class Boss implements Subject{

    private List<Observer> observers = new ArrayList<>();
    private String subjectState;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObs() {
        for (Observer obs: observers
             ) {
            obs.update(this,subjectState);
        }
    }

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
