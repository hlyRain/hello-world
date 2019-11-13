package cn.exercise.design_mode.strategy;

/**
 * 正常收费子类
 */
public class CashNormal extends CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
