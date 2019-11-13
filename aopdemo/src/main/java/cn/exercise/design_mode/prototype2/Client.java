package cn.exercise.mode.prototype2;


/**
 * 原型模式调用
 *
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        //浅复制复制
        Address address = new Address("jx", "gz");
        Programmer a = new Programmer("liaowp", address);
        a.setAddress(new Address("jx", "gz"));
        a.setName("liaowp");
        Programmer b = (Programmer) a.clone();
        b.setName("pwl");
        b.getAddress().setProvince("bj");
        System.err.println("a名字："+a.getName() +" 省份："+ a.getAddress().getProvince());
        System.err.println("b名字："+b.getName() +" 省份："+ b.getAddress().getProvince());

    }
}