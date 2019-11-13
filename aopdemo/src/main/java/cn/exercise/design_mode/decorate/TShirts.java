package cn.exercise.design_mode.decorate;

/**
 * 具体服饰 Tshirt
 */
public class TShirts extends Finery {
    @Override
    public void show() {
        System.out.println("大T恤");
        super.show();
    }
}
