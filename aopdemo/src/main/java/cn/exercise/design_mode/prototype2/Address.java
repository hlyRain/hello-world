package cn.exercise.design_mode.prototype2;

public class Address implements Cloneable{

    private String province;//省

    private String city;//市

    public Address(String province,String city){
        this.province=province;
        this.city=city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    protected Object clone()  {
        Address address = null;
        try {
            address = (Address)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制");
        } finally {
        }
        return address;
    }
}