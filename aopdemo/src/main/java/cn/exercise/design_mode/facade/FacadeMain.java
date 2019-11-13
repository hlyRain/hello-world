package cn.exercise.mode.facade;

/**
 * 外观模式Facade
 * 为子系统中的一组接口提供一个一致的界面，此模式定义一个高层接口，这一个接口使得这一子系统更加容易使用
 */
public class FacadeMain {
    public static void main(String[] args) {
        Fund jijin = new Fund();
        jijin.buyFund();
        jijin.sellFund();
    }
}
