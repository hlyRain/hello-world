package cn.exercise.design_mode.abstractFactory1;

/**
 *
 */
public class ProductFactory {

//    private static String directory = "North";
    private static String directory = "South";

    public static Fruit createFruit(){
        Fruit fruit=null;

        switch (directory){
            case "North":
                fruit = new NorthFruit();
                break;
            case "South":
                fruit = new SouthFruit();
                break;

        }
        return fruit;
    }

    public static Vegetable createVegetable(){
        Vegetable vegetable=null;

        switch (directory){
            case "North":
                vegetable = new NorthVegetable();
                break;
            case "South":
                vegetable = new SouthVegetable();
                break;

        }
        return vegetable;
    }


}
