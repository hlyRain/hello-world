package cn.exercise.mode.mediator;

public class MediatorMain {
    public static void main(String[] args) {
        SecurityCouncil unsc = new SecurityCouncil();
        USA c1 = new USA(unsc);
        Iraq c2 = new Iraq(unsc);

        unsc.setColleage1(c1);
        unsc.setColleage2(c2);

        c1.declare("禁止研制核武器，否则要发动战争！");
        c2.declare("我们没有核武器，也不怕侵略！");

    }
}
