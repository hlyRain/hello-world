package cn.exercise.mode.strategy;

/**
 * 商场打折优惠，比如打8折，传入字符串0.8
 */
public class CashRebate extends CashSuper{

    private double moneyRebate = 1d;

    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.parseDouble(moneyRebate);
    }

    @Override
    public double acceptCash(double money) {
        return money*moneyRebate;
    }
}
