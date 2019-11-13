package cn.exercise.mode.decorate;

/**
 * 具体服饰 破球鞋
 */
public class Sneakers extends Finery {
    @Override
    public void show() {
        System.out.println("破球鞋");
        super.show();
    }
}
