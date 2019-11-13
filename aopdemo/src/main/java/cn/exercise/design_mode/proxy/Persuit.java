package cn.exercise.design_mode.proxy;

/**
 * 追求者类
 */
public class Persuit implements IGiveGift{

    Student mm ;

    public Persuit() {
    }

    public Persuit(Student mm) {
        this.mm = mm;
    }

    @Override
    public void giveDolls() {
        System.out.println("送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println("送你鲜花");
    }

    @Override
    public void giveChocolate() {
        System.out.println("送你巧克力");
    }
}
