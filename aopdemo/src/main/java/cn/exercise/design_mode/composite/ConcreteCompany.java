package cn.exercise.design_mode.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式关键类
 */
public class ConcreteCompany extends Company{

    List<Company> children = new ArrayList<>();


    public ConcreteCompany(String name) {
        super(name);
    }

    public ConcreteCompany() {
    }

    @Override
    public void add(Company company) {
        children.add(company);
    }

    @Override
    public void remove(Company company) {
        children.remove(company);
    }

    @Override
    public void display(int depth) {
        System.out.print("-");
        for(int i=0;i<depth;i++){
            System.out.print("-");
        }
        System.out.println(name);
        for (Company compnent :children
             ) {
            compnent.display(depth+2);
        }
    }

    @Override
    public void lineOfDuty() {
        for (Company component: children) {
            component.lineOfDuty();
        }
    }
}
