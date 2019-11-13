package cn.exercise.mode.adapter;

public abstract class Player {

    protected  String  name;

    public abstract void attack();

    public  abstract  void defense();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
