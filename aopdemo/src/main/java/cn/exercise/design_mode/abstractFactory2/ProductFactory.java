package cn.exercise.design_mode.abstractFactory2;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 采用JAVA反射机制获得产品信息，产地信息写在配置文件中
 */
public class ProductFactory {

    private static final String PATH = "/Users/linyuhuang/myGitHub/hello-world/aopdemo/src/main/java/cn/exercise/design_mode/abstractFactory2/appConfig.properties";

    public static Fruit createFruit(){
        Fruit fruit=null;

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String preName = properties.getProperty("director");
        String className = "cn.exercise.design_mode.abstractFactory2."+preName+"Fruit";
        try {
            fruit = (Fruit)Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return fruit;
    }


    public static Vegetable createVegetable(){
        Vegetable vegetable=null;

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String preName = properties.getProperty("director");
        String className = "cn.exercise.design_mode.abstractFactory2."+preName+"Vegetable";
        try {
            vegetable = (Vegetable)Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return vegetable;
    }



}
