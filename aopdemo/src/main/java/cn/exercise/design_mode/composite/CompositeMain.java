package cn.exercise.mode.composite;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * 组合模式
 * 用于构造 树形结构 对象
 */
public class CompositeMain {

    public static void main(String[] args) {
        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.add(new HRDepartment("总公司人力资源部"));
        root.add(new FinanceDepartment("总公司财务部"));

        ConcreteCompany comp = new ConcreteCompany("上海华东分公司");
        comp.add(new HRDepartment("华东分公司人力资源部"));
        comp.add(new FinanceDepartment("华东分公司财务部"));
        root.add(comp);

        ConcreteCompany comp1 = new ConcreteCompany("南京办事部");
        comp1.add(new HRDepartment("南京办事部人力资源部"));
        comp1.add(new FinanceDepartment("南京办事部财务部"));
        comp.add(comp1);


        ConcreteCompany comp2 = new ConcreteCompany("杭州办事部");
        comp2.add(new HRDepartment("杭州办事部人力资源部"));
        comp2.add(new FinanceDepartment("杭州办事部财务部"));
        comp.add(comp2);

        System.out.println("结构图：");
        root.display(0);
        System.out.println("\n职责");
        root.lineOfDuty();


        ArrayList list = new ArrayList();
        // 增加：add() 将指定对象存储到容器中
        list.add("计算机网络");
        list.add("现代操作系统");
        list.add("java编程思想");
        list.add("java核心技术");
        list.add("java语言程序设计");
        System.out.println(list);






    }


}
