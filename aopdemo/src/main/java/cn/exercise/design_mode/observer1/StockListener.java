package cn.exercise.design_mode.observer1;

/**
 * 看股票的人
 */
public class StockListener {
    private String name;

    public StockListener(String name) {
        this.name = name;
    }


    public void closeStock(String msg) {
        System.out.println();
        System.out.printf("%s %s 关闭股票行情，继续工作！", msg, name);
    }

}
