package cn.exercise.design_mode.strategy;

/**
 * 商品信息
 */
public class Product {

    private String type;
    private String txtName;
    private String txtPrice;
    private String txtNum;

    public Product() {
    }

    public Product(String type, String txtName, String txtPrice, String txtNum) {
        this.type = type;
        this.txtName = txtName;
        this.txtPrice = txtPrice;
        this.txtNum = txtNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(String txtPrice) {
        this.txtPrice = txtPrice;
    }

    public String getTxtNum() {
        return txtNum;
    }

    public void setTxtNum(String txtNum) {
        this.txtNum = txtNum;
    }
}
