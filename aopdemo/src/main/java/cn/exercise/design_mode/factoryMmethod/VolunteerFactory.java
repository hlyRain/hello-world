package cn.exercise.design_mode.factoryMmethod;

public class VolunteerFactory implements IFactory {
    @Override
    public Leifeng createLeifeng() {
        return new Volunteer();
    }
}
