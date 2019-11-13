package cn.exercise.design_mode.observer;

public interface Subject {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObs();


}
