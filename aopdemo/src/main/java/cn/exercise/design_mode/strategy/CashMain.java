package cn.exercise.design_mode.strategy;

/**
 * 策略模式 前端代码实现
 */
public class CashMain {

    /**
     * 所有商品总价
     */
    private static double total = 0.0d;

    /**
     * @param product
     */
    private void btclick(Product product) {
        CashContext cashContext = new CashContext(product.getType());
        double totalPrices = 0d;
        totalPrices = cashContext.getResult(Double.parseDouble(product.getTxtPrice()) * Double.parseDouble(product.getTxtNum()));
        total += totalPrices;
        System.out.println(product.getTxtName() + " 单价：" + product.getTxtPrice() + " 数量：" + product.getTxtNum() + " 合计：" + totalPrices);
    }


    public static void main(String[] args) {
        CashMain cm = new CashMain();
//        输入商品
        Product product1 = new Product("打8折", "Java设计模式", "100", "1");
        Product product2 = new Product("满300减100", "Mysql入门到精通", "200", "3");
        Product product3 = new Product("正常收费", "Spring高级编程", "199", "2");
        Product product4 = new Product("正常收费", "Spring基础", "59", "3");

        cm.btclick(product1);
        cm.btclick(product2);
        cm.btclick(product3);
        cm.btclick(product4);
        System.out.println("总计：" + total + "元");
    }
}
