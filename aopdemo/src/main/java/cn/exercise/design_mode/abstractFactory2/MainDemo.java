package cn.exercise.design_mode.abstractFactory2;

/**
 * 采用JAVA反射机制获得产品信息，产地信息写在配置文件中
 * 用反射+配置文件 改进的抽象工厂
 */
public class MainDemo {

    public static void main(String[] args) {
        Fruit fruit = ProductFactory.createFruit();
        Vegetable vegetable = ProductFactory.createVegetable();


        fruit.fruitInfo();
        vegetable.vegetableInfo();



    }
}
