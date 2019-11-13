package cn.exercise.design_mode.bridge;

/**
 * 品牌手机抽象类，有属性软件（抽象），运行软件方法
 */
public abstract class HandsetBrand {

    /**
     * 建立两个抽象类的关联bridge
     */
    protected HandsetSoft soft;

    public void setHandsetSoft(HandsetSoft soft){
        this.soft = soft;
    }
    public  abstract void run();
}
