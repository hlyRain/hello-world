package cn.exercise.design_mode.strategy;

/**
 * 返利收费子类 满300减100，满600减200，
 */
public class CashReturn extends CashSuper{
    private double moneyCondition  = 0.0d;
    private double moneyReturn =0.0d;

    public CashReturn(String moneyCondition, String moneyReturn) {
        this.moneyCondition = Double.parseDouble(moneyCondition);
        this.moneyReturn = Double.parseDouble(moneyReturn);
    }

    @Override
    public double acceptCash(double money) {
        double result = 0.0d;
        if(money>=moneyCondition){
            result = money-Math.floor(money/moneyCondition)*moneyReturn;
        }

        return result;
    }
}
