package cn.exercise.design_mode.abstractFactory;

/**
 * 具体工厂类
 */
public class NorthProductFactory implements Factory {
    @Override
    public Fruit createFruit() {
        return new NorthFruit();
    }

    @Override
    public Vegetable createVegetable() {
        return new NorthVegetable();
    }
}
