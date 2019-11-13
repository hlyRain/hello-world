package cn.exercise.design_mode.builder;

/**
 * 建造者模式
 * 指挥者类
 */
public class Director {
    public void construct(Builder builder) {
        builder.builderPartA();
        builder.builderPartB();
    }

    public static void main(String[] args) {
        Director director = new Director();
        Builder b1 = new ConcreteBuilder1();
        Builder b2 = new ConcreteBuilder2();

        director.construct(b1);
        Product p1 = b1.getResult();
        p1.show();

        director.construct(b2);
        Product p2 = b2.getResult();
        p2.show();
    }

}
