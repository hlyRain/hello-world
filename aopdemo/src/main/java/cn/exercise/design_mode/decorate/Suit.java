package cn.exercise.design_mode.decorate;

/**
 * 具体服饰 西装
 */
public class Suit extends Finery {
    @Override
    public void show() {
        System.out.println("西装");
        super.show();
    }
}
