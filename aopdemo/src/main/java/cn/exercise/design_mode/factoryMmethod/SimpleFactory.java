package cn.exercise.design_mode.factoryMmethod;

/**
 * 简单工厂方法类及 Main执行
 */
public class SimpleFactory {

    public static Leifeng createLeifeng(String type){
        Leifeng result = null;
        switch (type){
            case "学雷锋的大学生":
                result = new Undergraduate();
                break;
            case "社区志愿者":
                result = new Volunteer();
                break;
        }
        return  result;
    }

    public static void main(String[] args) {
        /**
         * 简单工厂方法执行
         */
        Leifeng studentA = SimpleFactory.createLeifeng("学雷锋的大学生");
        studentA.buyRice();
        Leifeng studentB = SimpleFactory.createLeifeng("学雷锋的大学生");
        studentB.sweep();
        Leifeng studentC = SimpleFactory.createLeifeng("学雷锋的大学生");
        studentC.wash();
    }
}
