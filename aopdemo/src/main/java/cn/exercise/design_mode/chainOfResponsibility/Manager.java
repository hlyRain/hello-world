package cn.exercise.design_mode.chainOfResponsibility;

public abstract class Manager {

    protected String name;

    protected Manager superior;

    public  void setSuperior(Manager superior){
        this.superior = superior;
    }

    public  abstract  void requestApplication(Request request);


    public Manager(String name) {
        this.name = name;
    }
}
