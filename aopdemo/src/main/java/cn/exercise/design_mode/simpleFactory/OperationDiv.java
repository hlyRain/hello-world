package cn.exercise.mode.simpleFactory;

public class OperationDiv extends Operation{

    @Override
    public double getResult() throws Exception {
        double result = 0;
        if(_numberB == 0){
            throw new Exception("除数不能为0");
        }
        result = _numberA / _numberB;
        return result;
    }
}
