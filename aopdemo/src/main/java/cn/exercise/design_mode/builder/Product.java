package cn.exercise.mode.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品类
 */
public class Product {
    List<String> parts = new ArrayList<String>();

    /**
     * 添加产品部件
     * @param part
     */
    public void add(String part) {
        parts.add(part);
    }

    /**
     * 列举所有的产品部件
     */
    public void show() {
        System.out.println("\n产品创建 ----- ");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
