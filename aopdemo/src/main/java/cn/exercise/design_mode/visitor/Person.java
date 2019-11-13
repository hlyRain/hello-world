package cn.exercise.mode.visitor;

/**
 * 抽象类：人
 */
public abstract class Person {

//    protected Action action;

    //得到结论和反应
    public abstract void accept(Action visitor);


}
