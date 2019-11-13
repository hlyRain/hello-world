package cn.exercise.design_mode.abstractFactory1;

/**
 * 用户无需知道产品的产地即可获得产品信息，产地信息写在ProductFactory文件中
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
