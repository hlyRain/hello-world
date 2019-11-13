package cn.exercise.mode.proxy;

public class Proxy implements IGiveGift{
    Persuit gg;

    public Proxy(Student mm) {
        this.gg = new Persuit(mm);
    }

    public Proxy() {
    }

    @Override
    public void giveDolls() {
        gg.giveDolls();
    }

    @Override
    public void giveFlowers() {
        gg.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        gg.giveChocolate();
    }
}
