package cn.exercise.mode.decorate;

/**
 * 服饰类
 */
public class Finery extends Person{

    /**
     * 穿服饰的人
     */
    protected Person component;

    public  void decorate(Person component){
        this.component = component;
    }

    @Override
    public void show() {
        if(component!=null) {
            component.show();
        }
    }
}
