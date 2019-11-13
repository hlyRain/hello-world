package cn.exercise.design_mode.factoryMmethod;

public class UndergraduateFactory implements IFactory {
    @Override
    public Leifeng createLeifeng() {
        return new Undergraduate();
    }
}
