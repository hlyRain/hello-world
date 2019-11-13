package cn.exercise.mode.simpleFactory;

public class OperationSub extends Operation{

    @Override
    public double getResult() {
        double result = 0;
        result = _numberA - _numberB;
        return result;
    }
}
