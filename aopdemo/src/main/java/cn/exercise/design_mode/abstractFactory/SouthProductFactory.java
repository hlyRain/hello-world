package cn.exercise.design_mode.abstractFactory;
/**
 * 具体工厂类
 */
public class SouthProductFactory implements Factory{
    @Override
    public Fruit createFruit() {
        return new SouthFruit();
    }

    @Override
    public Vegetable createVegetable() {
        return new SouthVegetable();
    }
}
