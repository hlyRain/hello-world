package cn.exercise.mode.visitor;

public class Man extends Person {

    @Override
    public void accept(Action visitor) {
        visitor.getManConclusion(this);
    }
}
