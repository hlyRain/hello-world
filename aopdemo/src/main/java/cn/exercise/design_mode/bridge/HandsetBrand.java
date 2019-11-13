package cn.exercise.mode.bridge;

public abstract class HandsetBrand {

    //建立两个抽象类的关联bridge
    protected HandsetSoft soft;

    public void setHandsetSoft(HandsetSoft soft){
        this.soft = soft;
    }
    public  abstract void run();
}
