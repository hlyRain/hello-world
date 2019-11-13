package cn.exercise.design_mode.abstractFactory;

/**
 * 抽象工厂类（接口）
 */
public interface Factory {

    Fruit createFruit();

    Vegetable createVegetable();

}
