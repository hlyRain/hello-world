package cn.exercise.mode.simpleFactory;

public class OperationMul extends Operation{

    @Override
    public double getResult() {
        double result = 0;
        result = _numberA * _numberB;
        return result;
    }
}
