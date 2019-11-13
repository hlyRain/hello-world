package cn.exercise.design_mode.factoryMmethod;

/**
 * 工厂方法主类执行
 */
public class FactoryMethodMain {


    public static void main(String[] args) {
        IFactory factory = new UndergraduateFactory();
        Leifeng student = factory.createLeifeng();
        student.buyRice();
        student.wash();
        student.sweep();
    }


}
