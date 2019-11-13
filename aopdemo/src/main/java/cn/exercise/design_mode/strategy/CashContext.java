package cn.exercise.mode.strategy;


/**
 * 策略模式和简单工厂模式结合
 */
public class CashContext {
    private CashSuper cs = null;


    public CashContext(String type) {
        switch (type){
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满300减100":
                cs = new CashReturn("300","100");
                break;
            case "打8折":
                cs = new CashRebate("0.8");
                break;

        }
    }
    public double getResult(double money){
        return  cs.acceptCash(money);
    }
}
