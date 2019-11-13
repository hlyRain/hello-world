package cn.exercise.mode.abstractFactory1;

/**
 * 用简单工厂改进的抽象工厂
 */
public class MainDemo {

    public static void main(String[] args) {
        Fruit fruit = ProductFactory.createFruit();
        Vegetable vegetable = ProductFactory.createVegetable();


        fruit.fruitInfo();
        vegetable.vegetableInfo();



    }
}
