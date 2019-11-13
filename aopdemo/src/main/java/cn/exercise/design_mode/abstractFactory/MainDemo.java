package cn.exercise.design_mode.abstractFactory;

/**
 * 设计模式：抽象工厂模式
 */
public class MainDemo {

    public static void main(String[] args) {
        Factory northFactory = new NorthProductFactory();
        Factory southFactory = new SouthProductFactory();

        System.out.println("北方产品：");
        northFactory.createFruit().fruitInfo();
        northFactory.createVegetable().vegetableInfo();

        System.out.println("南方产品：");
        southFactory.createFruit().fruitInfo();
        southFactory.createVegetable().vegetableInfo();



    }
}
