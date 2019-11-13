package cn.exercise.design_mode.decorate;

/**
 * 具体服饰 领带
 */
public class Tie extends Finery {
    @Override
    public void show() {
        System.out.println("领带");
        super.show();
    }
}
