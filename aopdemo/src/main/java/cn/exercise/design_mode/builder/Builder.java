package cn.exercise.mode.builder;

/**
 * 抽象建造者类
 */
public abstract class Builder {

    public abstract void builderPartA();
    public abstract void builderPartB();
    public abstract Product getResult();
}
