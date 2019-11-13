package cn.exercise.design_mode.proxy;

public class ProxyMain {


    public static void main(String[] args) {
        Student student = new Student();
        student.setName("李婉蓉");
        student.setSex('F');
        Proxy hly = new Proxy(student);
        hly.giveChocolate();
        hly.giveDolls();
        hly.giveFlowers();

    }
}
