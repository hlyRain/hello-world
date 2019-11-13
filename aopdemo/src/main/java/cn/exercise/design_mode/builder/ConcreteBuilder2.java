package cn.exercise.design_mode.builder;

/**
 * 具体建造者类2
 */
public class ConcreteBuilder2 extends Builder {

    private Product product = new Product();

    @Override
    public void builderPartA() {
        product.add("part X");
    }

    @Override
    public void builderPartB() {
        product.add("part Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
