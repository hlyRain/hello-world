package cn.exercise.design_mode.builder;

/**
 * 具体建造者类1
 */
public class ConcreteBuilder1 extends Builder {

    private Product product = new Product();

    @Override
    public void builderPartA() {
        product.add("part A");
    }

    @Override
    public void builderPartB() {
        product.add("part B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
