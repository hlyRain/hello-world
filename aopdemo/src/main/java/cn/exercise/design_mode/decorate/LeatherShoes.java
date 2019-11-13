package cn.exercise.mode.decorate;

/**
 * 具体服饰 皮鞋
 */
public class LeatherShoes extends Finery {
    @Override
    public void show() {
        System.out.println("皮鞋");
        super.show();
    }
}
