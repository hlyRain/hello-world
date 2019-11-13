package cn.exercise.mode.factoryMmethod;

public class UndergraduateFactory implements IFactory {
    @Override
    public Leifeng createLeifeng() {
        return new Undergraduate();
    }
}
