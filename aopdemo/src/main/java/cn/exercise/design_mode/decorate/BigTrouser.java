package cn.exercise.mode.decorate;

/**
 * 具体服饰 垮裤
 */
public class BigTrouser extends Finery {
    @Override
    public void show() {
        System.out.println("垮裤");
        super.show();
    }
}
