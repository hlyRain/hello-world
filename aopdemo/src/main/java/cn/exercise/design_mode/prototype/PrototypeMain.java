package cn.exercise.design_mode.prototype;

/**
 * 原型模式：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的实例
 * 从一个对象创建另外一个可定制的对象，并且不用知道任何创建的细节
 * 浅复制 & 深复制
 */
public class PrototypeMain {

    public static void main(String[] args) {
        Resume a = new Resume("大鸟");
        a.setPersonalInfo("男","29");
        a.setWorkExperience("1998-2000","XXX公司");


        Resume b = a.clone();
        b.setWorkExperience("2011-2017","YY公司");

        Resume c = a.clone();
        c.setPersonalInfo("男","24");
        c.setWorkExperience("2017-2020","ZZX公司");

        a.display();
        b.display();
        c.display();
    }


}
