package cn.exercise.mode.prototype2;


/**
 * 1,要想实现深复制。需要继承Cloneable接口并且重写其中的clone方法，
 * 2,并且针对Programmer中的每一个子对象Address都做1操作
 * 3,在clone方法中增加 proto.address = (Address)address.clone();
 */
public class Programmer implements Cloneable{


    private String name;
    private Address address;


    public Programmer(String name,Address address){
        this.name=name;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Programmer clone() throws CloneNotSupportedException {
        Programmer proto = (Programmer) super.clone();
        proto.address = (Address)address.clone();
        return proto;
    }
}
