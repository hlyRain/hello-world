package cn.exercise.design_mode.simpleFactory;


/**
 * 设计模式：简单工厂模式
 */
public class OperationFactory {

    public static Operation createOperation(String operate){
        Operation oper = null;
        switch (operate){
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }


    public static void main(String[] args) {
        Operation oper ;
        oper = OperationFactory.createOperation("-");
        oper._numberA = 5 ;
        oper._numberB = 2 ;
        double result = 0;
        try {
            result = oper.getResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }

}
